package com.youcode.resourcium.Servlets;

import com.youcode.resourcium.Entities.Equipement;
import com.youcode.resourcium.Entities.Reservation;
import com.youcode.resourcium.Entities.User;
import com.youcode.resourcium.Exceptions.CustomEquipementException;
import com.youcode.resourcium.Exceptions.EquipementNotFoundException;
import com.youcode.resourcium.Service.EquipementService;
import com.youcode.resourcium.Service.ReservationService;
import com.youcode.resourcium.Service.UserService;
import com.youcode.resourcium.repository.EquipementRepository;
import com.youcode.resourcium.repository.ReservationRepository;
import com.youcode.resourcium.repository.UserRepository;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;


@WebServlet( urlPatterns = {"/saveReservation"})
public class ReservationServlet extends HttpServlet {

    private ReservationService reservationService;

    private EquipementService equipementService;

    private UserService userService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        UserRepository userRepository = new UserRepository(entityManagerFactory);
        userService = new UserService(userRepository);
        EquipementRepository equipementRepository = new EquipementRepository(entityManagerFactory);
        equipementService =  new EquipementService(equipementRepository);
        ReservationRepository reservationRepository = new ReservationRepository(entityManagerFactory);
        reservationService = new ReservationService(reservationRepository);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/saveReservation")) {
            String input = req.getParameter("employeeId").trim().replaceAll("[^\\d]", "");
            Long employeeId = Long.parseLong(input);
            int equipmentId = Integer.parseInt(req.getParameter("equipmentId"));
//            LocalDate reservationDate = LocalDate.parse(req.getParameter("reservationDate"));
//            LocalDate returnDate = LocalDate.parse(req.getParameter("returnDate"));

            User employee = userService.getUserById(employeeId);

            Equipement equipment = null;
            try {
                equipment = equipementService.getEquipementById(equipmentId);
            } catch (EquipementNotFoundException | CustomEquipementException e) {
                throw new RuntimeException(e);
            }

            Reservation reservation = new Reservation();
            reservation.setEmployee(employee);
            reservation.setEquipment(equipment);
            reservation.setReservationDate(LocalDate.now());
            reservation.setReturnDate((LocalDate.now().plusDays(1)));
            System.out.println(reservation.getEquipment().getName());

            reservationService.saveReservation(reservation);

            resp.sendRedirect("reservationSuccess.jsp");
        } else if (req.getPathInfo().equals("/cancelReservation")) {
            Long reservationId = Long.parseLong(req.getParameter("reservationId"));
            reservationService.cancelReservation(reservationId);

            resp.sendRedirect("cancellationSuccess.jsp");
        }else if (req.getPathInfo().equals("/updateReservation")) {
            Long reservationId = Long.parseLong(req.getParameter("reservationId"));
            String input = req.getParameter("employeeId").trim().replaceAll("[^\\d]", "");
            Long employeeId = Long.parseLong(input);
            int equipmentId = Integer.parseInt(req.getParameter("equipmentId"));
            LocalDate reservationDate = LocalDate.parse(req.getParameter("reservationDate"));
            LocalDate returnDate = LocalDate.parse(req.getParameter("returnDate"));
            User employee = userService.getUserById(employeeId);
            Equipement equipment = null;

        }
    }
}
