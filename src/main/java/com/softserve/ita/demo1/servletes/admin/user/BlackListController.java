package com.softserve.ita.demo1.servletes.admin.user;

import com.softserve.ita.demo1.entities.User;
import com.softserve.ita.demo1.services.impl.UserServiceImpl;
import com.softserve.ita.demo1.services.interfaces.UserService;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/user/blacklist/*")
public class BlackListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        UserService userService = new UserServiceImpl();

        try {
            String action = path.split("/")[1];
            Integer id = Integer.valueOf(path.split("/")[2]);
            User user = userService.getById(id);
            if(user == null){
                throw new NotFound();
            }

        } catch (ArrayIndexOutOfBoundsException | NumberFormatException | NotFound e){
            resp.setStatus(404);
        }

    }
}
