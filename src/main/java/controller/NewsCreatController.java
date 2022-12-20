package controller;

import Db.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "NewsCreatController", value = "/news_creat")
public class NewsCreatController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("JSP/newsCreating.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newsName = req.getParameter("newsName");
        String news = req.getParameter("news");

        if (newsName.isEmpty()){
            req.setAttribute("Error", 1);
            req.setAttribute("newsName", newsName);
            req.setAttribute("news", news);
            req.getRequestDispatcher("JSP/newsCreating.jsp").forward(req, resp);
        }

        DBManager manager = new DBManager();
        manager.newsCreating(newsName, news);
        resp.sendRedirect("/home");
    }
}
