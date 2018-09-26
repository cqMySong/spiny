package com.gioov.spiny.common.controller;

import com.gioov.common.web.http.FailureEntity;
import com.gioov.common.web.http.FailureResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class GlobalBasicErrorController extends AbstractErrorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalBasicErrorController.class);

    @Value("${server.error.path:${error.path:/error}}")
    public String errorPath = "/error";

    @Override
    public String getErrorPath() {
        return errorPath;
    }

    public GlobalBasicErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    /**
     * html
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView
     */
    @RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        HttpStatus httpStatus = getStatus(request);
        int code = httpStatus.value();
        Map<String, Object> errorAttributes = getErrorAttributes(request, true);
        LOGGER.error("status={},exception={}", code, errorAttributes);
        switch (code) {
            case 403:
                break;
            case 404:
                break;
            case 500:
                break;
            default:
                code = 500;
                break;
        }
        httpStatus = HttpStatus.valueOf(code);
        Map<String, Object> model = Collections.unmodifiableMap(getErrorAttributes(
                request, true));
        ModelAndView modelAndView = resolveErrorView(request, response, httpStatus, model);
        return (modelAndView == null ? new ModelAndView(code + "", model, httpStatus) : modelAndView);
    }

    /**
     * json
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ResponseEntity<? extends Object>
     * @throws Exception Exception
     */
    @RequestMapping
    @ResponseBody
    public ResponseEntity<? extends Object> error(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpStatus httpStatus = getStatus(request);
        int code = httpStatus.value();

        Map<String, Object> errorAttributes = getErrorAttributes(request, true);
        LOGGER.error("status={},errorAttributes={}", code, errorAttributes);

        switch (code) {
            case 400:
                break;
            case 403:
                break;
            case 404:
                break;
            case 500:
                break;
            default:
                code = 500;
                break;
        }

        httpStatus = HttpStatus.valueOf(code);
        FailureEntity failureEntity = new FailureEntity(httpStatus.getReasonPhrase(), httpStatus.value());
        return new FailureResponse<>(failureEntity, httpStatus);
    }

}
