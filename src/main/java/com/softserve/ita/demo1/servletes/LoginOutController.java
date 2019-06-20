package com.softserve.ita.demo1.servletes;

import com.softserve.ita.demo1.util.security.AuthManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginOutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthManager authManager = (AuthManager) req.getAttribute("Auth");
        authManager.logout();
        resp.sendRedirect("/login");
    }
}
