package com.sxd.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @author 飞鸟
 * @create 2019-11-22 16:41
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                HttpSession session = request.getSession();
                String username = (String) session.getAttribute("username");
                if(StringUtils.isBlank(username)){
                    request.setAttribute("error", "请登录！");
                    request.getRequestDispatcher("/login").forward(request,response);
                    return false;
                }
                return true;
            }
        }).excludePathPatterns(Arrays.asList("/","/login","/dashboard","/asserts/**","layui/**"));
    }
}
