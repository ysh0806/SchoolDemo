package com.yinshenghao.consumer.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:AllExceptions
 * Package:com.yinshenghao.consumer.configuration
 * Description:
 *
 * @Date:2020/3/4 23:48
 * @Author:ysh0806@sina.com
 */
@Configuration
public class AllExceptions implements HandlerExceptionResolver {

    @Nullable
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, @Nullable Object handler, Exception e) {
        ModelAndView mv = new ModelAndView();
        if (e instanceof RuntimeException && request.getRequestURI().equals("/removeTeacher")) {
            mv.setViewName("rmTeacherErrorPage");
        } else if (e instanceof RuntimeException && request.getRequestURI().equals("/removeClass")) {
            mv.setViewName("rmClassErrorPage");
        } else {
            e.printStackTrace();
            mv.setViewName("errorPage");
        }

        return mv;
    }
}
