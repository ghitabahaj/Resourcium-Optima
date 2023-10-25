package com.youcode.resourcium.repository;

import com.youcode.resourcium.Entities.Departement;
import com.youcode.resourcium.Entities.Reservation;

import jakarta.persistence.*;

import java.util.List;

public class ReservationRepository {
    private final EntityManagerFactory entityManagerFactory;

    public ReservationRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public Reservation saveReservation(Reservation reservation) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(reservation);
            transaction.commit();
            return reservation;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    public void cancelReservation(Long reservationId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Reservation reservation = entityManager.find(Reservation.class, reservationId);
            if (reservation != null) {
                entityManager.remove(reservation);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public List<Reservation> findAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
       TypedQuery<Reservation> query = entityManager.createQuery("SELECT r FROM Reservation r", Reservation.class);
        return query.getResultList();

    }
}
