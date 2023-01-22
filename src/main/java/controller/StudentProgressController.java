package controller;

import Db.DBManager;
import entity.DisciplineMark;
import entity.Student;
import entity.Term;
import function.Func;

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
        Term term = new Term();

        //1. получить студента по id
        String idStudent = request.getParameter("idStudent");

        String selectedId = request.getParameter("selectedId");
        Student student = manager.getStudentById(idStudent);

        // 2. получить все семестры
        ArrayList<Term> allTerm = manager.getTermbyIdStudent(idStudent);
        if (allTerm.isEmpty()) {
            request.setAttribute("student", student);
            request.setAttribute("termNull", 1);

            request.getRequestDispatcher("JSP/studentProgress.jsp").forward(request, response);
        } else {


            // 3. установить самый первый семестр
            if (selectedId == null) {
                term = allTerm.get(0);
            } else {
                term = Func.getTermbyID(allTerm, selectedId);
            }

            // 4. по выбранному семестру подтянуть дисциплины с оценками
            ArrayList<DisciplineMark> disciplineMark = manager.getDisciplineMarkbyTerm(term, idStudent);
            double averageMark = Func.getAverageMark(disciplineMark);

            request.setAttribute("student", student);
            request.setAttribute("allTerm", allTerm);
            request.setAttribute("term", term);
            request.setAttribute("disciplineMark", disciplineMark);
            request.setAttribute("averageMark", averageMark);
            request.getRequestDispatcher("JSP/studentProgress.jsp").forward(request, response);

        }
    }


}
