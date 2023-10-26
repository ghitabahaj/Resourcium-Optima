package com.youcode.resourcium.Service;

import com.youcode.resourcium.DTO.ReservationDTO;
import com.youcode.resourcium.Entities.Departement;
import com.youcode.resourcium.Entities.Reservation;
import com.youcode.resourcium.repository.ReservationRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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


    public List<ReservationDTO> getAllReservations() {

        List<Reservation> reservationsList =  reservationRepository.findAll();

        List<ReservationDTO> reservationsUpdated = reservationsList.stream()
                .filter(r ->  r.getEquipment().getType().equals("Jetable") && r.getReturnDate().isAfter(LocalDate.now()))
                .map(r -> {
                    ReservationDTO reservationDTO = new ReservationDTO();
                    reservationDTO.setReturnDate(r.getReturnDate().plusDays(r.getEquipment().getName().length()));

                    return reservationDTO;
                })
                .collect(Collectors.toList());

        return  reservationsUpdated;
    }




}
