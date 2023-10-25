package com.youcode.resourcium.Servlets;

import com.youcode.resourcium.Entities.Departement;
import com.youcode.resourcium.Entities.Reservation;
import com.youcode.resourcium.Exceptions.CustomEquipementException;
import com.youcode.resourcium.Service.DepartementService;
import com.youcode.resourcium.Service.EquipementService;
import com.youcode.resourcium.Service.ReservationService;
import com.youcode.resourcium.Service.UserService;
import com.youcode.resourcium.repository.DepartementRepository;
import com.youcode.resourcium.repository.EquipementRepository;
import com.youcode.resourcium.repository.ReservationRepository;
import com.youcode.resourcium.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class test {
    public static void main(String[] args) throws CustomEquipementException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EquipementRepository equipementRepository = new EquipementRepository(entityManagerFactory);
        EquipementService equipementService = new EquipementService(equipementRepository);
        ReservationRepository reservationRepository = new ReservationRepository(entityManagerFactory);
        ReservationService reservationService = new ReservationService(reservationRepository);
        UserRepository userRepository = new UserRepository(entityManagerFactory);
        UserService userService = new UserService(userRepository);

        reservationService.saveReservation(new Reservation(equipementService.getEquipementById(4L) ,userService.getUserById(13L) ,  LocalDate.of(2023,9,30) , LocalDate.now()));
        reservationService.saveReservation(new Reservation(equipementService.getEquipementById(1L) ,userService.getUserById(8L) ,  LocalDate.of(2023,9,20) , LocalDate.now()));


        List<Reservation> reservations = reservationRepository.findAll();

        System.out.println(reservations);




    }
}
