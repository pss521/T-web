package net.mlike.chenhui.one.controller;

import com.google.common.base.Strings;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import net.mlike.chenhui.one.util.CurrentUser;

@WebFilter(urlPatterns={"/*"})
public class UserFilter
        implements Filter
{
    public void init(FilterConfig filterConfig)
            throws ServletException
    {}

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException
    {
        String token = servletRequest.getParameter("token");
        if (Strings.isNullOrEmpty(token)) {
            token = ((HttpServletRequest)servletRequest).getHeader("token");
        }
        CurrentUser.set(token);
        filterChain.doFilter(servletRequest, servletResponse);
        CurrentUser.set("");
    }

    public void destroy() {}
}
