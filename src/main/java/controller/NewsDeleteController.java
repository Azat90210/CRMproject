package controller;

import Db.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "NewsDeleteController", value = "/news_delete")
public class NewsDeleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idNews = request.getParameter("idNews");
        DBManager manager = new DBManager();
        manager.deleteNews(idNews);
        response.sendRedirect("/home");
    }
}
