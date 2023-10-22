package com.youcode.resourcium.Service;

import com.youcode.resourcium.Entities.Reservation;
import com.youcode.resourcium.repository.ReservationRepository;

public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.saveReservation(reservation);
    }

    public void cancelReservation(Long reservationId) {
        reservationRepository.cancelReservation(reservationId);
    }
}
