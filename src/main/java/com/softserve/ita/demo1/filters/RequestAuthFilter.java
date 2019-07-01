package com.softserve.ita.demo1.filters;

import com.google.gson.Gson;
import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.util.security.AuthManager;
import com.softserve.ita.demo1.util.security.RememberMeCookie;

import javax.security.sasl.SaslException;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RequestAuthFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(true);

        AuthManager authManager = new AuthManager(session, res, req);

        if (authManager.guest()) {
            Gson gson = new Gson();
            Cookie[] reqCookies = req.getCookies();
            if (reqCookies != null) {
                for (Cookie cookie : reqCookies) {
                    if (cookie.getName().equals("remember-me")) {
                        RememberMeCookie rememberMeCookie = gson.fromJson(cookie.getValue(), RememberMeCookie.class);
                        try {
                            authManager.tryLoginByCookie(rememberMeCookie);
                        } catch (DAOException e) {
                            throw new ServletException(e.getMessage(), e);
                        }
                    }
                }
            }
        }

        request.setAttribute("Auth", authManager);

        if (!authManager.guest() && !authManager.getUser().isAdmin() && authManager.getUser().isBlocked()) {
            req.getRequestDispatcher("/views/userblocked.jsp").forward(req, res);
        } else {
            chain.doFilter(request, response);
        }


    }

    public void destroy() {
        //close any resources here
    }
}
