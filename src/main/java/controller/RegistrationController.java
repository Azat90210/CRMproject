package controller;

import Db.DBManager;
import entity.Role;
import entity.User;
import entity.UserRole;
import function.Func;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RegistrationController", value = "/registration")
public class RegistrationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager manager = new DBManager();
        ArrayList<Role> allRole = manager.getAllRole();
        request.setAttribute("allRole", allRole);
        request.getRequestDispatcher("JSP/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager manager = new DBManager();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String roleId = request.getParameter("roleId");

        ArrayList<Role> allRole = manager.getAllRole();
        request.setAttribute("allRole", allRole);
        ArrayList<User> getLogin = manager.getLogins();

        if (Func.loginMatch(login)) {

            if (login.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || roleId.isEmpty()) {
                request.setAttribute("Error", 1);
                request.setAttribute("login", login);
                request.setAttribute("password", password);
                request.setAttribute("firstName", firstName);
                request.setAttribute("lastName", lastName);
                request.setAttribute("roleId", roleId);

                request.getRequestDispatcher("JSP/registration.jsp").forward(request, response);
            }

            manager.addUser(login, password, lastName, firstName);
            User getUserId = manager.getUserId(login);
            String userId = String.valueOf(getUserId.getId());
            manager.addIds(roleId, userId);

            if (manager.isLogin(login, password, roleId)) {
                //перейти домой
                request.getSession().setAttribute("isLogin", 1);

                UserRole getUser = manager.getUser(login, roleId);
                request.getSession().setAttribute("RoleId", roleId);
                request.getSession().setAttribute("RoleName", getUser.getName());
                request.getSession().setAttribute("FirstName", getUser.getFirstName());
                request.getSession().setAttribute("LastName", getUser.getLastName());
                response.sendRedirect("/home");
            }
        } else {
            //вывести ошибку
            request.setAttribute("ErrorNewLogin", 1);
            request.setAttribute("allRole", allRole);
            request.getRequestDispatcher("JSP/registration.jsp").forward(request, response);
        }
    }
}