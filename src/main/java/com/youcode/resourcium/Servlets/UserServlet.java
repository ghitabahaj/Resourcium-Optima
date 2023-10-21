package com.youcode.resourcium.Servlets;

import com.youcode.resourcium.Entities.Departement;
import com.youcode.resourcium.Entities.User;
import com.youcode.resourcium.Service.DepartementService;
import com.youcode.resourcium.Service.UserService;
import com.youcode.resourcium.repository.DepartementRepository;
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


@WebServlet(urlPatterns = {"/users" , "/addEmployee" , "/removeEmployee" , "/removeUser" ,"/updateEmployee"})
public class UserServlet extends HttpServlet {
    private EntityManagerFactory entityManagerFactory;
    private UserService userService;
    private  DepartementService departmentService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        UserRepository userRepository = new UserRepository(entityManagerFactory);
        userService = new UserService(userRepository);
        DepartementRepository departementRepository = new DepartementRepository(entityManagerFactory);
        departmentService = new DepartementService(departementRepository);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            List<User> employees = userService.getAllEmployees();
            req.setAttribute("employees", employees);
            List<Departement> departments = departmentService.getAllDepartements();
            req.setAttribute("departments", departments);
            req.setAttribute("url","users");
            req.getRequestDispatcher("home.jsp").forward(req, resp);

        } else {
            resp.sendRedirect("login.jsp"); // Redirect to the login page if the user is not logged in
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/removeUser") && req.getMethod().equals("POST")) {
            Long id = Long.parseLong(req.getParameter("EmpId"));
            userService.deleteUser(id);
            List<User> employees = userService.getAllEmployees();
            req.setAttribute("employees", employees);
            resp.sendRedirect("users");
        }else if(path.equals("/updateEmployee") && req.getMethod().equals("POST")){
            Long id = Long.parseLong(req.getParameter("EmpIdUpdate"));
            String Fname = req.getParameter("first-name-update");
            String Lname = req.getParameter("last-name-update");
            String Username = req.getParameter("username-update");
            String email = req.getParameter("email-update");
            String Phone = req.getParameter("number-update");
            String departmentId = req.getParameter("dep-id");

            // Assuming you have a method to retrieve the Departement by its ID
            Departement department = departmentService.getDepartementById(Long.parseLong(departmentId));

            User user = userService.getUserById(id);
            user.setEmail(email);
            user.setFirstName(Fname);
            user.setLastName(Lname);
            user.setNumberPhone(Phone);
            user.setNumberPhone(Phone);
            user.setUsername(Username);
            user.setDepartement(department);

            List<User> employees = userService.getAllEmployees();
            req.setAttribute("employees", employees);
            resp.sendRedirect("users");
        }

    }
}
