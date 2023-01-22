package controller;

import Db.DBManager;
import entity.Role;
import entity.UserRole;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager manager = new DBManager();
        ArrayList<Role> allRole = manager.getAllRole();
        request.setAttribute("allRole", allRole);

        request.getRequestDispatcher("JSP/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String roleId = request.getParameter("roleId");


        DBManager manager = new DBManager();
        ArrayList<Role> allRole = manager.getAllRole();


        if (login.isEmpty() || password.isEmpty() || roleId.isEmpty()) {
            request.setAttribute("ErrorEmpty", 1);
            request.setAttribute("login", login);
            request.setAttribute("password", password);
            request.setAttribute("roleId", roleId);
            request.setAttribute("allRole", allRole);

            request.getRequestDispatcher("JSP/login.jsp").forward(request, response);
        }


        if (manager.isLogin(login, password, roleId)) {
            //перейти домой
            request.getSession().setAttribute("isLogin", 1);

            UserRole getUser = manager.getUser(login, roleId);
            request.getSession().setAttribute("RoleId", roleId);
            request.getSession().setAttribute("RoleName", getUser.getName());
            request.getSession().setAttribute("FirstName", getUser.getFirstName());
            request.getSession().setAttribute("LastName", getUser.getLastName());
            response.sendRedirect("/home");

        } else {
            //вывести ошибку
            request.setAttribute("ErrorLogin", 1);
            request.setAttribute("allRole", allRole);
            request.getRequestDispatcher("JSP/login.jsp").forward(request, response);
        }
    }
}





















