package com.softserve.ita.demo1.servletes;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.entities.Category;
import com.softserve.ita.demo1.services.interfaces.CategoryService;
import com.softserve.ita.demo1.services.impl.CategoryServiceImpl;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CategoryController extends HttpServlet {

    private CategoryService categoryService;

    @Override
    public void init() throws ServletException {
        super.init();
        categoryService = new CategoryServiceImpl();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getPathInfo();
        String categoryAlias = path.split("/")[1];

        try {
            Category activeCategory = categoryService.getByAlias(categoryAlias);
            if (activeCategory == null) {
                throw new NotFound();
            }
            request.setAttribute("activeCategory", activeCategory);
        } catch (DAOException e) {
            throw new ServletException(e.getMessage());
        } catch (NotFound e) {
            response.setStatus(404);
        }


        try {
            List<Category> categories = categoryService.getAll();
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("/views/category.jsp").forward(request, response);
        } catch (DAOException e) {
            throw new ServletException(e.getMessage());
        }

    }
}
