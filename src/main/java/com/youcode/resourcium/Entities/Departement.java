package com.youcode.resourcium.Entities;


import jakarta.persistence.*;

@Entity
@Table(name = "departement")
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User ChefDepartment;

    public Departement(){}
    public Departement(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Departement(String name, String description) {

        this.name = name;
        this.description = description;
    }
    public Departement(String name, String description,User Chef) {

        this.name = name;
        this.description = description;
        this.ChefDepartment = Chef;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getChefDepartment() {
        return ChefDepartment;
    }

    public void setChefDepartment(User chefDepartment) {
        ChefDepartment = chefDepartment;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
