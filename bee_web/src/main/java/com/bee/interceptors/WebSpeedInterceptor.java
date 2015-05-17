package com.bee.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by suntongwei on 15/5/16.
 */
public class WebSpeedInterceptor implements HandlerInterceptor {

    private static final Logger Log = LoggerFactory.getLogger(WebSpeedInterceptor.class);

    private static final String Flag = "SpeedTest";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute(Flag, System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long useTime = System.currentTimeMillis() - Long.valueOf(request.getAttribute(Flag).toString());
        if(useTime > 3000) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Log.error("Page visit time: " + useTime + ", Class: "
                    + handlerMethod.getBean().getClass().getName()
                    + ", Method: " + handlerMethod.getMethod().getName());
        }
        request.removeAttribute(Flag);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
}
