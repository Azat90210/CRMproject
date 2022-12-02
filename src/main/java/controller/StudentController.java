package controller;

import Db.DBManager;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudentController", value = "/student")
public class StudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager manager = new DBManager();
        ArrayList<Student> allStudents = manager.getAllStudent();
        req.setAttribute("allStudents", allStudents);
        req.getRequestDispatcher("JSP/student.jsp").forward(req, resp);
    }
}
