package com.softserve.ita.demo1.servletes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CrudController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");

        String path = req.getPathInfo();
        if(path.split("/").length == 2){
            String methodName = path.split("/")[2];
            Integer id = path.split("/")[1];
        }

        switch (methodName){
            case "create":
                doCreate(req,resp);
                case "update"
        }
        // create
        // update

        switch (method) {

            case "DELETE":
                doDelete(req, resp);
                break;

            default:
                doIndex(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");

        switch (method) {
            case "PUT":
                doPut(req, resp);
                break;
            case "PATCH":
                doPatch(req, resp);
                break;
        }
    }

    protected void doPatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
