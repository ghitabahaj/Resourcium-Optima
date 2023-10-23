package com.youcode.resourcium.Servlets;

import com.youcode.resourcium.Entities.Departement;
import com.youcode.resourcium.Entities.User;
import com.youcode.resourcium.Service.UserService;
import com.youcode.resourcium.repository.UserRepository;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/UpdateAccount","/ChangeEmail" , "/ChangePassword"})
public class UpdateAccServlet extends HttpServlet {
    private EntityManagerFactory entityManagerFactory;
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        UserRepository userRepository = new UserRepository(entityManagerFactory);
        userService = new UserService(userRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            Long id = (Long) session.getAttribute("id");
            User u = userService.getUserById(id);
            req.setAttribute("user", u);
            req.setAttribute("url","UpdateAccount");
            req.getRequestDispatcher("home.jsp").forward(req, resp);

        } else {
            resp.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
