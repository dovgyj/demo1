package com.softserve.ita.demo1.servletes;

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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher rd = request.getRequestDispatcher("views/register.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordConfirmation = req.getParameter("password_confirmation");

        Validator validator = new Validator();

        if(!validator.hasMinLength(2,name)){
            throw new IllegalArgumentException("Name must contain minimum 2 chars");
        }

        if(!validator.isValidEmail(email) ){
            throw new IllegalArgumentException("Email is not valid");
        }

        if(!validator.hasMinLength(6,password)){
            throw new IllegalArgumentException("Password must contain at least 6 characters");
        }

        if(!password.equals(passwordConfirmation)){
            throw new IllegalArgumentException("Password and password confirmation dont same");
        }

        SecurityManager securityManager = new SecurityManager();
        UserService service = new UserServiceImpl();


        String passwordHash = securityManager.hashPassword(password);
        User user = new User(name,passwordHash,email);
        service.add(user);


        AuthManager authManager = (AuthManager) req.getAttribute("Auth");
        authManager.login(user);

        resp.sendRedirect("/");

    }
}
