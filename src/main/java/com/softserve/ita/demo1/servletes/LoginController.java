package com.softserve.ita.demo1.servletes;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.util.Validator;
import com.softserve.ita.demo1.util.security.AuthManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/login.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Validator validator = new Validator();

        if (!validator.isValidEmail(email) || !validator.hasMinLength(6, password)) {
            resp.setStatus(400);
        } else {
            AuthManager authManager = (AuthManager) req.getAttribute("Auth");

            try {
                if (authManager.tryLogin(password, email)) {

                    authManager.deleteCookieFromDatabase();

                    if (req.getParameter("check_me_out") != null && req.getParameter("check_me_out").equals("check_me_out")) {

                        authManager.setRememberMeCookie();
                    } else {
                        authManager.deleteCookieFromClient();
                    }

                    if (authManager.getUser().isAdmin()) {
                        resp.sendRedirect("/admin/item/index");
                    } else {
                        resp.sendRedirect("/");
                    }

                } else {
                    req.setAttribute("error", "Email or password does not match!");
                    req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
                }
            } catch (DAOException e) {
                throw new ServletException(e.getMessage());
            }
        }
    }
}
