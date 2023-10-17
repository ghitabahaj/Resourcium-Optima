package com.youcode.resourcium.Servlets;


import com.youcode.resourcium.Entities.User;
import com.youcode.resourcium.Service.UserService;
import com.youcode.resourcium.repository.UserRepository;
import jakarta.persistence.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private EntityManagerFactory entityManagerFactory;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        UserRepository userRepository = new UserRepository(entityManagerFactory);
         userService = new UserService(userRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userService.authenticateUser(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("home.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }


    @Override
    public void destroy() {
        entityManagerFactory.close();
    }
}

