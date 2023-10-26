package com.youcode.resourcium.Entities;


import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipement equipment;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private User employee;


    @Column(name = "reservation_date")
    private LocalDate reservationDate;

    @Column(name = "return_date")
    private LocalDate returnDate;


    public Reservation(Equipement equipment, User employee, LocalDate reservationDate, LocalDate returnDate) {
        this.equipment = equipment;
        this.employee = employee;
        this.reservationDate = reservationDate;
        this.returnDate = returnDate;
    }

    public Reservation() {}

    public Equipement getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipement equipment) {
        this.equipment = equipment;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
