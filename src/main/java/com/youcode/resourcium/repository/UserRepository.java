package com.youcode.resourcium.repository;

import com.youcode.resourcium.Entities.Departement;
import com.youcode.resourcium.Entities.User;
import jakarta.persistence.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;


public class UserRepository {
        private EntityManagerFactory entityManagerFactory;


    public UserRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public boolean userExistsInDatabase(String username, String password) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        User user = null;
        try {
            user = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        entityManager.close();
        return user != null;
    }

    public boolean doesUserExist(String username){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username ", User.class);
        query.setParameter("username", username);
        User user = null;
        try {
            user = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        entityManager.close();
        return user != null;

    }
    public void persistUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public String hashPassword(String password) {
      return null;
    }

    public boolean isValidEmail(String email) {
        return email.matches("^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$");
    }

    public boolean isStrongPassword(String password) {
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*\\d.*");
    }

    public boolean isValidUser(User user) {
        return !user.getUsername().isEmpty() && !user.getEmail().isEmpty() && !user.getPassword().isEmpty();
    }


    public User getUserByUsername(String Username){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
        query.setParameter("username", Username);
        return  query.getSingleResult();
    }

    public List<User> findAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.role.id = :role" , User.class);
        query.setParameter("role",1);
        return query.getResultList();
    }

    public void delete(Long id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            User user = entityManager.find(User.class, id);
            if (user != null) {
                entityManager.remove(user);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            // Handle the exception appropriately
        } finally {
            entityManager.close();
        }
    }


    public void update(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            User mergedUser = entityManager.merge(user); // Capture the merged instance
            entityManager.persist(mergedUser); // Persist the changes
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); // Handle or log the exception as needed
        } finally {
            entityManager.close();
        }
    }

    public User findById(Long id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(User.class, id);
    }

    }


