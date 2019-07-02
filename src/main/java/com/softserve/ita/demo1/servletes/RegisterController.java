package com.softserve.ita.demo1.servletes;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.softserve.ita.demo1.services.interfaces.UserService;
import com.softserve.ita.demo1.services.impl.UserServiceImpl;
import com.softserve.ita.demo1.util.Validator;
import com.softserve.ita.demo1.util.security.AuthManager;
import com.softserve.ita.demo1.util.security.SecurityManager;

public class RegisterController extends HttpServlet {

    private SecurityManager securityManager;
    private UserService userService;
    private Validator validator;

    @Override
    public void init() throws ServletException {
        super.init();
        securityManager = new SecurityManager();
        userService = new UserServiceImpl();
        validator = new Validator();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("views/register.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordConfirmation = req.getParameter("password_confirmation");


        if (!validator.hasMinLength(2, name) || !validator.isValidEmail(email) || !validator.hasMinLength(6, password) || !password.equals(passwordConfirmation)) {
            resp.setStatus(400);
        } else {
            String passwordHash = securityManager.hashPassword(password);
            User user = new User(name, passwordHash, email);
            try {
                userService.add(user);
            } catch (DAOException e) {
                throw new ServletException(e.getMessage());
            }


            resp.sendRedirect("/login");
        }


    }
}
