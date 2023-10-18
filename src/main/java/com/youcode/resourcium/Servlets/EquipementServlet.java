package com.youcode.resourcium.Servlets;

import com.youcode.resourcium.Entities.Equipement;
import com.youcode.resourcium.Service.EquipementService;

import com.youcode.resourcium.repository.EquipementRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/equipements")
public class EquipementServlet extends HttpServlet {

    private final EquipementService equipementService;

    public EquipementServlet() {
        this.equipementService = new EquipementService(new EquipementRepository());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET requests
        // Retrieve all equipements and pass them to the view
        request.setAttribute("equipements", equipementService.getAllEquipements());
        request.getRequestDispatcher("equipements.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST requests

        String action = request.getParameter("action");


    }

}

