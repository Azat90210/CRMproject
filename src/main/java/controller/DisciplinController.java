package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DisciplinController", value = "/disciplin")
public class DisciplinController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        req.getRequestDispatcher("JSP/discipline.jsp").forward(req, resp);
    }


}
