package com.youcode.resourcium.Service;

import com.youcode.resourcium.Entities.Equipement;
import com.youcode.resourcium.Entities.Reservation;
import com.youcode.resourcium.Entities.User;
import com.youcode.resourcium.repository.DepartementRepository;
import com.youcode.resourcium.repository.EquipementRepository;
import com.youcode.resourcium.repository.ReservationRepository;
import com.youcode.resourcium.repository.UserRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReservationServiceTest {

    @Test
    public void saveReservation() {

        ReservationRepository reservationRepository = mock(ReservationRepository.class);
        ReservationService reservationService = new ReservationService(reservationRepository);

        UserRepository userRepository = mock(UserRepository.class);
        UserService userService = new UserService(userRepository);

        EquipementRepository equipementRepository = mock(EquipementRepository.class);
        EquipementService equipementService = new EquipementService(equipementRepository);

        Reservation reservation = new Reservation(new Equipement(), new User(), LocalDate.now(), LocalDate.now().plusDays(1));


        when(reservationRepository.saveReservation(reservation)).thenReturn(reservation);


        Reservation savedReservation = reservationService.saveReservation(reservation);
        assertEquals(reservation, savedReservation);

        verify(reservationRepository).saveReservation(reservation);
    }

    @Test
    void cancelReservation() {

    }

    @Test
    void getAllReservations() {

    }
}