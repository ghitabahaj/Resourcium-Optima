package com.youcode.resourcium;

import java.io.*;

import com.youcode.resourcium.Entities.Role;
import com.youcode.resourcium.Entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init( )  {
        message = "hello";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        User u = new User(1L,"Soah00","123","kim","Soah","kimsaoh@gmail.com",new Role());
//        u = entityManager.merge(u);
//        entityManager.persist(u);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        entityManagerFactory.close();

        // Hello

    }

    public void destroy(){

    }
}