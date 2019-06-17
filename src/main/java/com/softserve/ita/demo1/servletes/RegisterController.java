package com.softserve.ita.demo1.servletes;

import com.softserve.ita.demo1.db.UserDAO;
import com.softserve.ita.demo1.db.UserDAOImpl;
import com.softserve.ita.demo1.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.softserve.ita.demo1.services.UserService;
import com.softserve.ita.demo1.services.UserServiceImpl;
import com.softserve.ita.demo1.util.AuthManager;
import com.softserve.ita.demo1.util.SecurityManager;

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

        //validation
        SecurityManager securityManager = new SecurityManager();
        UserService service = new UserServiceImpl();


        String passwordHash = securityManager.hashPassword(password);
        User user = new User(name,passwordHash,email);
        service.add(user);


        AuthManager authManager = (AuthManager) req.getAttribute("Auth");
        authManager.login(user);

        resp.sendRedirect("/home");

    }
}
