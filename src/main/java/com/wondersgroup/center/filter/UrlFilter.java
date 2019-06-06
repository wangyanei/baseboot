package com.wondersgroup.center.filter;

import com.wondersgroup.center.config.GetRequestAndReponse;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wxk on 2019/5/31.
 */
@Order(1)
@WebFilter(filterName = "urlfilter",urlPatterns = "/api/*")
public class UrlFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)request;
        XssHttpServletRequestWrapper xssHttpServletRequestWrapper=new XssHttpServletRequestWrapper(req);
        GetRequestAndReponse.setRequest(xssHttpServletRequestWrapper);
        GetRequestAndReponse.setResponse((HttpServletResponse)response);
        chain.doFilter(xssHttpServletRequestWrapper,response);
    }

    @Override
    public void destroy() {

    }
}
