package controller;

import Db.DBManager;
import entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Student_delete", value = "/student_delete")
public class Student_delete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. получить id с jsp
        //2. выполнить запрос в бд
        //3. вернуться на страницу студенты


        String idStudent = req.getParameter("idStudent");
        DBManager manager = new DBManager();
        manager.deleteStudent(idStudent);
        resp.sendRedirect("/student");
    }
}
