package com.youcode.resourcium.Servlets;

import com.youcode.resourcium.Entities.Departement;
import com.youcode.resourcium.Service.DepartementService;
import com.youcode.resourcium.repository.DepartementRepository;
import com.youcode.resourcium.repository.UserRepository;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "DepartementServlet",urlPatterns= {"/departements","/saveDep","/removeDep","/updateDep"})
public class DepartementServlet  extends HttpServlet {

    private  DepartementService departmentService;


    @Override
    public void init()throws ServletException{
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        DepartementRepository departementRepository = new DepartementRepository(entityManagerFactory);
        departmentService = new DepartementService(departementRepository);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
                List<Departement> departments = departmentService.getAllDepartements();
                request.setAttribute("departments", departments);
                request.setAttribute("url","departements");
                request.getRequestDispatcher("home.jsp").forward(request, response);

        } else {
            response.sendRedirect("login.jsp"); // Redirect to the login page if the user is not logged in
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/saveDep") && request.getMethod().equals("POST")) {
            String nom = request.getParameter("nameDep");
            String description = request.getParameter("descDep");
            departmentService.saveDepartement(new Departement(nom, description));
            List<Departement> departments = departmentService.getAllDepartements();
            request.setAttribute("departments", departments);
            response.sendRedirect("departements");
        }else if(path.equals("/removeDep") && request.getMethod().equals("POST") ){
            Long id = Long.parseLong(request.getParameter("depId"));
            departmentService.deleteDepartement(id);;
            List<Departement> departments = departmentService.getAllDepartements();
            request.setAttribute("departments", departments);
            response.sendRedirect("departements");
        }else if((path.equals("/updateDep") && request.getMethod().equals("POST"))){
            Long idDep = Long.parseLong(request.getParameter("depa-id"));
            System.out.println(request.getParameter("depa-id"));
            String name = request.getParameter("name-update");
            String description = request.getParameter("desc-update");
            Departement departement = departmentService.getDepartementById(idDep);
            departement.setName(name);
            departement.setDescription(description);
            departmentService.updateDepartement(departement);
            List<Departement> departments = departmentService.getAllDepartements();
            request.setAttribute("departments", departments);
            response.sendRedirect("departements");

        }
    }
    }