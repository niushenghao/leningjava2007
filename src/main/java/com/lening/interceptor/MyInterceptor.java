package com.lening.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 牛胜浩
 * @date 2021/4/14 16:23
 */
public class MyInterceptor implements HandlerInterceptor {

    private List<String> exceptUrls;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (exceptUrls.contains(uri)){
            return true;
        }else {
            Object ub = request.getSession().getAttribute("ub");
            if (ub == null){
                request.getRequestDispatcher("/index.html").forward(request, response);
            }else {
                return true;
            }
        }
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    public List<String> getExceptUrls() {
        return exceptUrls;
    }

    public void setExceptUrls(List<String> exceptUrls) {
        this.exceptUrls = exceptUrls;
    }
}
