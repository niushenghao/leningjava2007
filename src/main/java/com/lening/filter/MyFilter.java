package com.lening.filter;

import org.apache.http.HttpRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


/**
 * @author 牛胜浩
 * @date 2021/4/14 16:29
 */
public class MyFilter implements Filter {

    Set<String> notCheckUrl = new HashSet<String>();


    public void init(FilterConfig filterConfig) throws ServletException {
        String urls = filterConfig.getInitParameter("notCheckUrl");
        for (String url:urls.split(",")){
            notCheckUrl.add(url.trim());
        }
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
        System.out.println(uri);
        if (notCheckUrl.contains(uri)){
            chain.doFilter(request, response);
        }else {
            Object ub = req.getSession().getAttribute("ub");
            if (ub == null){
                req.getRequestDispatcher("/index.html").forward(request, response);
            }else {
                chain.doFilter(request, response);
            }
        }
    }

    public void destroy() {

    }
}
