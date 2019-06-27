package com.softserve.ita.demo1.servletes.admin.category;

import com.softserve.ita.demo1.entities.Category;
import com.softserve.ita.demo1.services.interfaces.CategoryService;
import com.softserve.ita.demo1.services.impl.CategoryServiceImpl;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/category/update/*")
public class UpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService service = new CategoryServiceImpl();
        String path = req.getPathInfo();
        String id = path.split("/")[1];
        Integer categoryId = null;

        try {
            categoryId = Integer.valueOf(id);
            Category category = service.getById(categoryId);
            if(category == null){
                throw new NotFound();
            }
            req.setAttribute("category",category);
            req.getRequestDispatcher("/views/admin/category/edit.jsp").forward(req,resp);
        } catch (NumberFormatException | NotFound e){
            resp.setStatus(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer id = Integer.valueOf(req.getParameter("id"));

        CategoryService service = new CategoryServiceImpl();

        Category category = service.getById(id);
        category.setName(name);

        service.update(category);

        resp.sendRedirect("/admin/category/update/" + category.getId());
    }
}
