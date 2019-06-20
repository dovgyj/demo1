package com.softserve.ita.demo1.servletes;

import com.google.gson.Gson;
import com.softserve.ita.demo1.entities.Auntification;
import com.softserve.ita.demo1.services.AuntificationService;
import com.softserve.ita.demo1.services.AuntificationServiceImpl;
import com.softserve.ita.demo1.util.security.AuthManager;
import com.softserve.ita.demo1.util.security.RememberMeCookie;
import com.softserve.ita.demo1.util.security.SecurityManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/login.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        //validation

        AuthManager authManager = (AuthManager) req.getAttribute("Auth");
        SecurityManager securityManager = new SecurityManager();

        if(authManager.tryLogin(password, email)){
            if(authManager.getUser().isAdmin()){
                resp.sendRedirect("/admin/dashboard");
            }else{
                resp.sendRedirect("/home");
            }

            AuntificationService auntificationService = new AuntificationServiceImpl();
            Gson gson = new Gson();
            Cookie[] reqCookies = req.getCookies();
            if (reqCookies != null) {
                for (Cookie cookie : reqCookies) {
                    if (cookie.getName().equals("remember-me")) {
                        RememberMeCookie rememberMeCookie = gson.fromJson(cookie.getValue(),RememberMeCookie.class);
                        auntificationService.delete(rememberMeCookie.getSelector());
                    }
                }
            }

            if (req.getParameter("check_me_out") != null && req.getParameter("check_me_out").equals("check_me_out")) {

                String selector = securityManager.generateSelector();
                String validator = securityManager.generateRememberMeToken();
                String hasedValidator = securityManager.hashRememberMeToken(validator);

                RememberMeCookie rememberMeCookie = new RememberMeCookie(selector,hasedValidator);

                Auntification auntification = new Auntification();
                auntification.setId(authManager.getUser().getId());
                auntification.setSelector(selector);
                auntification.setValidator(validator);

                auntificationService.add(auntification);

                Cookie cookie = new Cookie("remember-me", gson.toJson(rememberMeCookie));

                cookie.setPath("/");
                cookie.setMaxAge(60 * 60 * 24 * 30);
                resp.addCookie(cookie);
            } else {
                Cookie cookie = new Cookie("remember-me", "");
                cookie.setPath("/");
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }else{
            req.setAttribute("error","Email or password does not match!");
            req.getRequestDispatcher("/views/login.jsp").forward(req,resp);
        }


    }
}
