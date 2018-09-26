package com.gioov.spiny.common.security;

import com.gioov.common.web.http.FailureEntity;
import com.gioov.common.web.http.SuccessEntity;
import com.gioov.spiny.common.constant.Api;
import com.gioov.spiny.common.constant.FailureMessage;
import com.gioov.spiny.common.constant.Page;
import com.gioov.spiny.common.constant.Url;
import com.gioov.spiny.common.druid.DruidConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.gioov.spiny.user.service.UserService.SYSTEM_ADMIN;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfiguration.class);

    @Autowired
    @Qualifier("simpleUserDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    /**
     * 获取 ServletContext
     */
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                // 禁用 csrf
                .csrf().disable()

                // 禁用 ROLE_ANONYMOUS 角色
                .anonymous().disable()

                // 解决 in a frame because it set 'X-Frame-Options' to 'deny'. 问题
                .headers().frameOptions().disable()

                .and().authorizeRequests()

                // 静态资源 url ，无需登录认证权限
                .antMatchers(Url.STATIC).permitAll()
                .antMatchers(Page.User.LOGIN).permitAll()
                .antMatchers(DruidConfiguration.DRUID_URL)

                // Druid 需要权限或者系统管理员角色才能访问
                .hasAnyAuthority("ROLE_" + SYSTEM_ADMIN, DruidConfiguration.DRUID_URL.toUpperCase())

                // 其它请求均需要认证 或 .antMatchers(Url.PATH_PATTERN).authenticated()
                .anyRequest().authenticated()

                // 开启表单登录，设置登录 url
                .and().formLogin().loginPage(Page.User.LOGIN)
                .usernameParameter(Page.User.LOGIN_ACCOUNT_STRING).passwordParameter(Page.User.LOGIN_PASSWORD_STRING)

                // 自定义登录表单提交 url
                .loginProcessingUrl(Api.User.LOGIN)

                // 登录成功处理
                .successHandler(

                        // 登录成功，返回 status 200 ， json 返回 SimpleUser
                        new AuthenticationSuccessHandler() {
                            @Override
                            public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                                SimpleUser simpleUser = (SimpleUser) authentication.getPrincipal();

                                httpServletResponse.setStatus(HttpStatus.OK.value());
                                httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                                PrintWriter printWriter = httpServletResponse.getWriter();
                                printWriter.write(new SuccessEntity(simpleUser).toString());
                                printWriter.flush();
                                printWriter.close();
                            }
                        })

                // 登录失败处理
                .failureHandler(

                        // 登录失败，返回 status 404 ， json 返回失败提示
                        new AuthenticationFailureHandler() {
                            @Override
                            public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                                httpServletResponse.setStatus(HttpStatus.NOT_FOUND.value());
                                httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                                PrintWriter printWriter = httpServletResponse.getWriter();
                                printWriter.write(new FailureEntity(FailureMessage.LOGIN_FAIL).toString());
                                printWriter.flush();
                                printWriter.close();
                            }
                        })

                .and()

                // 开启记住我功能， cookie 保存登录数据
                .rememberMe().rememberMeParameter(Page.User.LOGIN_REMEMBER_ME_STRING);

    }

}
