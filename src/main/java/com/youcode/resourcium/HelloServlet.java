package com.youcode.resourcium;

import java.io.*;

import com.youcode.resourcium.Entities.Employee;
import com.youcode.resourcium.Service.EmployeService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init( )  {
        message = "hello";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee e = new Employee(1L,"ghita","123","First","Last","gh@gh.com","employe");
        entityManager.getTransaction().begin();
        e = entityManager.merge(e);
        entityManager.persist(e);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        // Hello

    }

    public void destroy(){

    }
}