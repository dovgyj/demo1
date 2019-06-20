package com.softserve.ita.demo1.filters;

import com.softserve.ita.demo1.util.security.AuthManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestAdminFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        AuthManager authManager = (AuthManager) servletRequest.getAttribute("Auth");
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        if (authManager.guest() || !authManager.getUser().isAdmin()) {
            resp.sendRedirect("/login");
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }


    }
}
