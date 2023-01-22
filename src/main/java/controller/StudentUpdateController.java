package controller;

import Db.DBManager;
import entity.News;
import entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StudentUpdateController", value = "/student_update")
public class StudentUpdateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager manager = new DBManager();

        String idStudent = request.getParameter("idStudent");
        Student student = manager.getStudentById(idStudent);
        request.setAttribute("student", student);
        request.getRequestDispatcher("JSP/studentUpdate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
