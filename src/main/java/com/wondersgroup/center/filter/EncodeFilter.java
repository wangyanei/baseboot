package com.wondersgroup.center.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by wxk on 2019/5/31.
 */

@Order(2)
@WebFilter(filterName = "encodefilter",urlPatterns = "/api/*")
public class EncodeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)request;
        req.setCharacterEncoding("utf-8");
        System.out.print("vvvvv");
        chain.doFilter(req,response);
    }

    @Override
    public void destroy() {

    }
}
