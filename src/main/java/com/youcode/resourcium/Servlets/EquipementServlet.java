package com.youcode.resourcium.Servlets;

import com.youcode.resourcium.Entities.Departement;
import com.youcode.resourcium.Entities.Equipement;
import com.youcode.resourcium.Exceptions.CustomEquipementException;
import com.youcode.resourcium.Service.DepartementService;
import com.youcode.resourcium.Service.EquipementService;

import com.youcode.resourcium.repository.DepartementRepository;
import com.youcode.resourcium.repository.EquipementRepository;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet( urlPatterns = { "/equipements","/addEquipment"})
public class EquipementServlet extends HttpServlet {

    private  EquipementService equipementService;
    private  DepartementService departmentService;

    @Override
    public void init()throws ServletException{
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EquipementRepository equipementRepository = new EquipementRepository(entityManagerFactory);
        equipementService = new EquipementService(equipementRepository);
        DepartementRepository departementRepository = new DepartementRepository(entityManagerFactory);
        departmentService = new DepartementService(departementRepository);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            List<Equipement> equipements = null;
            try {
                equipements = equipementService.getAllEquipements();
            } catch (CustomEquipementException e) {
                throw new RuntimeException(e);
            }
            request.setAttribute("equipements", equipements);
            request.setAttribute("url","equipements");
            List<Departement> departments = departmentService.getAllDepartements();
            request.setAttribute("departments", departments);
            request.getRequestDispatcher("home.jsp").forward(request, response);

        } else {
            response.sendRedirect("login.jsp"); // Redirect to the login page if the user is not logged in
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {





    }

}

