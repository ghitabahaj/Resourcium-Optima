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

    public Equipement(String name, String type, Date dateOfPurchase, Date dateOfMaintenance, String state , Departement dep) {
        this.name = name;
        this.type = type;
        this.dateOfPurchase = dateOfPurchase;
        this.dateOfMaintenance = dateOfMaintenance;
        this.state = state;
        this.department = dep;
    }

    public Equipement(String name, String type, Date dateOfPurchase, String state , Departement dep) {
        this.name = name;
        this.type = type;
        this.dateOfPurchase = dateOfPurchase;
        this.dateOfMaintenance = dateOfMaintenance;
        this.state = state;
        this.department = dep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Date getDateOfMaintenance() {
        return dateOfMaintenance;
    }

    public void setDateOfMaintenance(Date dateOfMaintenance) {
        this.dateOfMaintenance = dateOfMaintenance;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Departement getDepartment() {
        return department;
    }

    public void setDepartment(Departement department) {
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

