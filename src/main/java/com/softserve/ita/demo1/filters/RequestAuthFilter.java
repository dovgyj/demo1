package com.softserve.ita.demo1.filters;

import com.softserve.ita.demo1.util.AuthManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RequestAuthFilter implements Filter{

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

       // String uri = req.getRequestURI();
        //this.context.log("Requested Resource::"+uri);

        HttpSession session = req.getSession(true);

        AuthManager authManager = new AuthManager(session);

        request.setAttribute("Auth", authManager);

        chain.doFilter(request, response);

        /*if(session == null && !(uri.endsWith("html") || uri.endsWith("LoginServlet"))){
            this.context.log("Unauthorized access request");
            res.sendRedirect("login.html");
        }else{
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }*/


    }

    public void destroy() {
        //close any resources here
    }
}
