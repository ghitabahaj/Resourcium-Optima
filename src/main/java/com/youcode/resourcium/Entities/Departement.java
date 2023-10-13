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
    @JoinColumn(name = "head_of_department_id")
    private Employee headOfDepartment;


    public Departement(){}
    public Departement(int id, String name, String description, Employee headOfDepartment) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.headOfDepartment = headOfDepartment;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", headOfDepartment=" + headOfDepartment +
                '}';
    }
}
