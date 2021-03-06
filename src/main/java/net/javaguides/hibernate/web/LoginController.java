package net.javaguides.hibernate.web;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.javaguides.hibernate.dao.UserDao;



@WebServlet(name = "Login", value = "/Login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao loginDao;

    public void init() {
        loginDao = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            authenticate(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");



        if (loginDao.validate(username, password) == 0) {
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }

            HttpSession currentSession = request.getSession();
            currentSession.setAttribute("customer", username);
            currentSession.setMaxInactiveInterval(5*60);

            response.sendRedirect("login-success.jsp");
        }
        else if (loginDao.validate(username, password) == 1) {
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }

            HttpSession currentSession = request.getSession();
            currentSession.setAttribute("admin", username);
            currentSession.setMaxInactiveInterval(5*60);

            response.sendRedirect("login-success2.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }



}