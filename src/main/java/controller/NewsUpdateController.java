package controller;

import Db.DBManager;
import entity.News;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "NewsUpdateController", value = "/news_update")
public class NewsUpdateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idNews = request.getParameter("idNews");

        DBManager manager = new DBManager();


        News news = manager.getNews(idNews);
        request.setAttribute("news", news);
        request.getRequestDispatcher("JSP/newsUpdate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String text = request.getParameter("text");
        String ids = request.getParameter("news");

        DBManager manager = new DBManager();
        manager.updateNews(name, text, ids);

        request.setAttribute("name", name);
        request.setAttribute("text", text);
        request.setAttribute("idNews", ids);
        response.sendRedirect("/home");
    }
}
