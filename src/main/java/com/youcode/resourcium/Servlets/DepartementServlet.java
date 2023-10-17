package com.youcode.resourcium.Servlets;

import com.youcode.resourcium.Entities.Departement;
import com.youcode.resourcium.Service.DepartementService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "DepartementServlet", value = "/departement")
public class DepartementServlet  extends HttpServlet {
    private final DepartementService departmentService;

    public DepartementServlet(DepartementService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Departement> departments = departmentService.getAllDepartements();
        request.setAttribute("departments", departments);
        request.getRequestDispatcher("departments.jsp").forward(request, response);
    }
}