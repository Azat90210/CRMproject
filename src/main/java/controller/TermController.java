package controller;

import Db.DBManager;
import entity.Term;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TermController", value = "/term")
public class TermController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        DBManager manager = new DBManager();
        ArrayList<Term> allTerm = manager.getAllTerm();
        req.setAttribute("allTerm", allTerm);
        req.getRequestDispatcher("JSP/term.jsp").forward(req, resp);
    }


}