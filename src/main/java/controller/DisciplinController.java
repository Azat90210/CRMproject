package controller;

import Db.DBManager;
import entity.Disciplin;
import entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DisciplinController", value = "/disciplin")
public class DisciplinController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager manager = new DBManager();
        ArrayList<Disciplin> allDisciplin = manager.getAllDisciplin();
        req.setAttribute("allDisciplin", allDisciplin);
        req.getRequestDispatcher("JSP/discipline.jsp").forward(req, resp);
    }
}
