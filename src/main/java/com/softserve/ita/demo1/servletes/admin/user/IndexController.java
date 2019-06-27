package com.softserve.ita.demo1.servletes.admin.user;

import com.softserve.ita.demo1.entities.User;
import com.softserve.ita.demo1.services.impl.UserServiceImpl;
import com.softserve.ita.demo1.services.interfaces.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class IndexController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        List<User> users = userService.getAllUsers();
        req.setAttribute("users",users);
        req.getRequestDispatcher("/views/admin/user/index.jsp").forward(req,resp);
    }
}
