package com.softserve.ita.demo1.servletes.admin.user;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.entities.BlackList;
import com.softserve.ita.demo1.entities.User;
import com.softserve.ita.demo1.services.impl.BlackListServiceImpl;
import com.softserve.ita.demo1.services.impl.UserServiceImpl;
import com.softserve.ita.demo1.services.interfaces.BlackListService;
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

    private UserService userService;
    private BlackListService blackListService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl();
        blackListService = new BlackListServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();

        try {
            String action = path.split("/")[1];
            Integer id = Integer.valueOf(path.split("/")[2]);
            User user = userService.getById(id);
            if (user == null) {
                throw new NotFound();
            }

            switch (action) {
                case "add":
                    BlackList blackList = new BlackList(user.getId());
                    blackListService.add(blackList);
                    break;
                case "remove":
                    blackListService.remove(user.getId());
                    break;
                default:
                    throw new NotFound();
            }

            resp.sendRedirect("/admin/users");

        } catch (ArrayIndexOutOfBoundsException | NumberFormatException | NotFound e) {
            resp.setStatus(404);
        } catch (DAOException e) {
            throw new ServletException(e.getMessage());
        }


    }
}
