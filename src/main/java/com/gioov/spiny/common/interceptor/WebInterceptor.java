package com.gioov.spiny.common.interceptor;

import com.gioov.spiny.common.security.SimpleUser;
import com.gioov.spiny.system.service.DictionaryService;
import com.gioov.spiny.user.entity.UserEntity;
import com.gioov.spiny.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static com.gioov.spiny.user.service.UserService.SYSTEM_ADMIN;

/**
 * @author godcheese
 * @date 2018-02-22
 */
public class WebInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebInterceptor.class);

    @Autowired
    private UserService userService;

    @Autowired
    private DictionaryService dictionaryService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        String contextPathKey = "_contextPath";
        String userKey = "_user";
        String systemAdmin = SYSTEM_ADMIN;

        if (modelAndView != null) {

            if (modelAndView.getModel().containsKey(systemAdmin)) {
                if (modelAndView.getModel().get(systemAdmin) == null) {
                    modelAndView.addObject(systemAdmin, systemAdmin);
                }
            } else {
                modelAndView.addObject(systemAdmin, systemAdmin);
            }

            String contextPath;
            if ((contextPath = request.getContextPath()) != null) {
                modelAndView.addObject(contextPathKey, contextPath);
            } else {
                contextPath = "";
                modelAndView.addObject(contextPathKey, contextPath);
            }

            SimpleUser userPrincipal = userService.getUserPrincipal(request);
            if (userPrincipal != null) {
                Map<String, Object> map = new HashMap<>(2);
                map.put("id", null);
                map.put("username", null);
                UserEntity userEntity = userService.getOneByIdNoPassword(userPrincipal.getId());
                if (userEntity != null) {
                    map.put("id", userEntity.getId());
                    map.put("username", userEntity.getUsername());
                }
                modelAndView.addObject(userKey, map);

            }


            if (modelAndView.getModel().containsKey(userKey)) {
                if (modelAndView.getModel().get(userKey) == null) {
                    modelAndView.addObject(userKey, new HashMap<>(0));
                }
            }
        }


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
