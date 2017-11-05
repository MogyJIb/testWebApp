package by.gstu.training.controllers;


import by.gstu.training.database.common.DaoFactory;
import by.gstu.training.database.common.dao.UserDao;
import by.gstu.training.model.*;


import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class TestRunnerController extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException {
        performTask(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException {
        performTask(req, resp);
    }


    public void performTask(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html; charset=Cp1251");
        PrintWriter out = null;
        Context context = null;

        try {
            out = resp.getWriter();

            DaoFactory factory = DaoFactory.getDAOFactory(DaoFactory.MSSQL);

            o(out,factory.getTourDao().findAll());


        } catch (IOException e) {
            out.print(e.getMessage()+"<br>");
            out.print("PrintWriter не проинициализирован"+"<br>");
        }
        out.print("All successful"+"<br>");

    }

    private void o(PrintWriter out, List<Tour> entities){
        for(Entity entity : entities){
            out.print(entity+"<br>");
        }

    }
}


