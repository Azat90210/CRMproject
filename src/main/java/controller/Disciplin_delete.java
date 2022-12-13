package controller;

import Db.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Disciplin_delete", value = "/disciplin_delete")
public class Disciplin_delete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idDisciplin = request.getParameter("idDisciplin");
        DBManager manager = new DBManager();
        manager.deleteDisciplin(idDisciplin);
        response.sendRedirect("/disciplin");
    }
}
