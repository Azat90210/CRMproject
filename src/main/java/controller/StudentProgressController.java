package controller;

import Db.DBManager;
import entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudentProgressController", value = "/student_progress")
public class StudentProgressController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBManager manager = new DBManager();
        ArrayList<Student> allStudents = manager.getAllStudent();
        request.setAttribute("allStudents", allStudents);
        request.getRequestDispatcher("JSP/studentProgress.jsp").forward(request, response);


        //1. Получить студента по id
        //2. Получить все семестры
        //3 Установить самый первый семестр
        //4. По выбранному семестру подтянуть дисциплины с оценками

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
