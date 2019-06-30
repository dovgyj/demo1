package com.softserve.ita.demo1.servletes;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.entities.Item;
import com.softserve.ita.demo1.services.impl.ItemServiceImpl;
import com.softserve.ita.demo1.services.interfaces.ItemService;
import com.softserve.ita.demo1.util.OrderBin;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class BinController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderBin orderBin = (OrderBin) request.getAttribute("orderBin");
        List<Item> itemList = orderBin.getItemList();
        request.setAttribute("items", itemList);
        RequestDispatcher rd = request.getRequestDispatcher("/views/bin.jsp");
        rd.forward(request, response);
    }


}