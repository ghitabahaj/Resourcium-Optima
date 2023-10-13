package com.youcode.resourcium.Entities;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "equipment")
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "date_of_purchase")
    private Date dateOfPurchase;

    @Column(name = "date_of_maintenance")
    private Date dateOfMaintenance;

    @Column(name = "state")
    private String state;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departement department;

    public Equipement(){}

    public Equipement(int id, String name, String type, Date dateOfPurchase, Date dateOfMaintenance, String state, Departement department) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.dateOfPurchase = dateOfPurchase;
        this.dateOfMaintenance = dateOfMaintenance;
        this.state = state;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Equipement{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", dateOfPurchase=" + dateOfPurchase +
                ", dateOfMaintenance=" + dateOfMaintenance +
                ", state='" + state + '\'' +
                ", department=" + department +
                '}';
    }
}

