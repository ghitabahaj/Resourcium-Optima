package com.youcode.resourcium.Servlets;

import com.youcode.resourcium.Entities.Departement;
import com.youcode.resourcium.Service.DepartementService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "DepartementServlet", value = "/departements")
public class DepartementServlet  extends HttpServlet {
    private final DepartementService departmentService;

    public DepartementServlet(DepartementService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("username") != null) {
            List<Departement> departments = departmentService.getAllDepartements();
            request.setAttribute("departments", departments);
            request.getRequestDispatcher("departments.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp"); // Redirect to the login page if the user is not logged in
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("add")) {
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            Departement newDepartment = new Departement(name, description);
            departmentService.saveDepartement(newDepartment);

        } else if (action.equalsIgnoreCase("update")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            Departement updatedDepartment = new Departement(id, name, description);
            departmentService.updateDepartement(updatedDepartment);
        } else if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Departement departmentToDelete = departmentService.getDepartementById(id);
            departmentService.deleteDepartement(departmentToDelete);
        }

        response.sendRedirect(request.getContextPath() + "/departments");
    }
}