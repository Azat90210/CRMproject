package controller;

import Db.DBManager;
import entity.*;
import function.Func;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TermController", value = "/term")
public class TermController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager manager = new DBManager();
        Term term = new Term();
        //1. получить id Term
        String idTerm = req.getParameter("idTerm");
        String selectedId = req.getParameter("selectedId");
        Term termId = manager.getTermId(idTerm);
        // 2. получить все семестры
        ArrayList<Term> allTerm = manager.getTermbyId(idTerm);

        if (selectedId == null) {
            term = allTerm.get(0);
        } else {
            term = Func.getTermbyID(allTerm, selectedId);
        }

        ArrayList <TermDiscipline> termDiscipline = manager.getDisciplineByTerm(term, idTerm);

        req.setAttribute("termId", termId);
        req.setAttribute("allTerm", allTerm);
        req.setAttribute("term", term);
        req.setAttribute("termDiscipline", termDiscipline);


//        req.setAttribute("id_term", termDiscipline.getId());
//        req.setAttribute("term", termDiscipline.getTermName());
//        req.setAttribute("duration", termDiscipline.getDuration());
//        req.setAttribute("discipline", termDiscipline.getDisciplineName());
        req.getRequestDispatcher("JSP/term.jsp").forward(req, resp);
    }


}
