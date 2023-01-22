package controller;

import Db.DBManager;
import entity.News;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "NewsController", value = "/news_controller")
public class NewsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager manager = new DBManager();
        ArrayList<News> allNews = manager.getAllNews();
        request.setAttribute("allNews", allNews);
        request.getRequestDispatcher("JSP/home.jsp").forward(request, response);
    }


}
