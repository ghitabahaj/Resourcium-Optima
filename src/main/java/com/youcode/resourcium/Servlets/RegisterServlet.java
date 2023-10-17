package com.youcode.resourcium.Servlets;

import com.youcode.resourcium.Entities.User;
import com.youcode.resourcium.Entities.Role;


import com.youcode.resourcium.Exceptions.UserAlreadyExistsException;
import com.youcode.resourcium.Service.UserService;
import com.youcode.resourcium.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value="/signup")
public class RegisterServlet extends HttpServlet {
    private EntityManagerFactory entityManagerFactory;
    private UserService userService; // Declare userService as a class field

    @Override
    public void init() throws ServletException {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        UserRepository userRepository = new UserRepository(entityManagerFactory);
        userService = new UserService(userRepository); // Initialize userService
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Role role = entityManager.find(Role.class, 1L); // Assuming your Role entity has a reference to the role with ID 1
        entityManager.close();

        newUser.setRole(role);

        try {
            userService.addNewUser(newUser);
        } catch (UserAlreadyExistsException e) {
            throw new RuntimeException(e);
        }

        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        response.sendRedirect("login.jsp");
    }



    @Override
    public void destroy() {
        entityManagerFactory.close();
    }
}
