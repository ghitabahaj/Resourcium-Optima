package com.youcode.resourcium.Servlets;


import com.youcode.resourcium.Entities.Departement;
import com.youcode.resourcium.Entities.User;
import com.youcode.resourcium.Service.DepartementService;
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
import java.util.List;

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
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            resp.sendRedirect("home.jsp");
        } else {
            resp.sendRedirect("login.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.authenticateUser(username, password);
        System.out.println(password);
        System.out.println(user.getPassword());
        HttpSession session = request.getSession();
//            session.setAttribute("user",user);
        session.setAttribute("username", user.getUsername());
        session.setAttribute("email", user.getEmail());
        session.setAttribute("FirstName", user.getFirstName());
        session.setAttribute("LastName", user.getLastName());
        session.setAttribute("id", user.getId());
        response.sendRedirect("home.jsp");
    }


    @Override
    public void destroy() {
        entityManagerFactory.close();
    }
}

