package com.youcode.resourcium.repository;

import com.youcode.resourcium.Entities.Reservation;

import jakarta.persistence.*;

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
}
