package com.softserve.ita.demo1.servletes;

import com.google.gson.Gson;
import com.softserve.ita.demo1.entities.Auntification;
import com.softserve.ita.demo1.services.AuntificationService;
import com.softserve.ita.demo1.services.AuntificationServiceImpl;
import com.softserve.ita.demo1.util.Validator;
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

        Validator validator = new Validator();

        if(!validator.isValidEmail(email)){
            throw new IllegalArgumentException("Email is not valid");
        }

        if(!validator.hasMinLength(6,password)){
            throw new IllegalArgumentException("Password must contain at least 6 characters " + password);
        }

        AuthManager authManager = (AuthManager) req.getAttribute("Auth");

        if(authManager.tryLogin(password, email)){

            authManager.deleteCookieFromDatabase();

            if (req.getParameter("check_me_out") != null && req.getParameter("check_me_out").equals("check_me_out")) {

                authManager.setRememberMeCookie();
            } else {
                authManager.deleteCookieFromClient();
            }

            if(authManager.getUser().isAdmin()){
                resp.sendRedirect("/admin/dashboard");
            }else{
                resp.sendRedirect("/home");
            }

        }else{
            req.setAttribute("error","Email or password does not match!");
            req.getRequestDispatcher("/views/login.jsp").forward(req,resp);
        }


    }
}
