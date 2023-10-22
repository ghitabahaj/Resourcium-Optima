package com.youcode.resourcium.Entities;


import jakarta.persistence.*;


@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipement equipment;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private User employee;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
