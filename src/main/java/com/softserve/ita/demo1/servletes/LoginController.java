package com.softserve.ita.demo1.servletes;

import com.softserve.ita.demo1.entities.User;
import com.softserve.ita.demo1.services.UserService;
import com.softserve.ita.demo1.services.UserServiceImpl;
import com.softserve.ita.demo1.util.AuthManager;
import com.softserve.ita.demo1.util.SecurityManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {

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

        if(authManager.tryLogin(password, email)){
            resp.sendRedirect("/home");
        }

        resp.sendRedirect("/register");
    }
}
