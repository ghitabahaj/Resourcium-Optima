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
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(reservation);
        tx.commit();
        return  reservation;
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
