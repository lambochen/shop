package com.chensanwa.shop.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 2018/7/7
 * Time: 18:28
 */
public class CorsFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse res = (HttpServletResponse) servletResponse;

        res.setContentType("text/html;charset=UTF-8");

        res.setHeader("Access-Control-Allow-Origin", "*");

        res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");

        res.setHeader("Access-Control-Max-Age", "0");

        res.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");

        res.setHeader("Access-Control-Allow-Credentials", "true");

        res.setHeader("XDomainRequestAllowed","1");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
