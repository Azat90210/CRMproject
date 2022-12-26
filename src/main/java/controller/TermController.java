package controller;

import Db.DBManager;
import entity.Disciplin;
import entity.DisciplineMark;
import entity.News;
import entity.Term;
import function.Func;

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
        Term term = new Term();
        ArrayList<Term> allTerm = manager.getAllTerm();

        String selectedId = req.getParameter("selectedId");
        if (selectedId == null) {
            term = allTerm.get(0);
        } else {
            term = Func.getTermbyID(allTerm, selectedId);
        }
        ArrayList<Disciplin> discipline = manager.getDisciplineByTerm(term);

        req.setAttribute("allTerm", allTerm);
        req.setAttribute("term", term);
        req.setAttribute("discipline", discipline);
        req.getRequestDispatcher("JSP/term.jsp").forward(req, resp);
    }


}
