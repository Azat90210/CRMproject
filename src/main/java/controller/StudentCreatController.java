package controller;

import Db.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StudentCreatController", value = "/student_creat")
public class StudentCreatController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("JSP/studentCreating.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lastName = req.getParameter("lastName");
        String firstName = req.getParameter("firstName");
        String groupName = req.getParameter("groupName");
        String registrationDate = req.getParameter("registrationDate");

        if (firstName.isEmpty() || lastName.isEmpty() || groupName.isEmpty() || registrationDate.isEmpty()){
            req.setAttribute("Error", 1);
            req.setAttribute("lastName", lastName);
            req.setAttribute("firstName", firstName);
            req.setAttribute("groupName", groupName);
            req.setAttribute("registrationDate", registrationDate);

            req.getRequestDispatcher("JSP/studentCreating.jsp").forward(req, resp);
        }

        DBManager manager = new DBManager();
        manager.studentCreating(lastName, firstName, groupName, registrationDate);
        resp.sendRedirect("/student");
    }
}
