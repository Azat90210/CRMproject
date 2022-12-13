package controller;

import Db.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DisciplinCreatController", value = "/disciplin_creat")
public class DisciplinCreatController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        req.getRequestDispatcher("JSP/disciplinGreating.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String disciplinName = req.getParameter("disciplinName");


        if (disciplinName.isEmpty()){
            req.setAttribute("Error", 1);
            req.setAttribute("disciplinName", disciplinName);
            req.getRequestDispatcher("JSP/disciplinGreating.jsp").forward(req, resp);
        }

        DBManager manager = new DBManager();
        manager.disciplinCreating(disciplinName);
        resp.sendRedirect("/disciplin");
    }
}
