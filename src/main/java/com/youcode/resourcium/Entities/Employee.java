package com.youcode.resourcium.Entities;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class Employee  extends User{
    @Column(name = "date_embauche")
    private LocalDate dateEmbauche;


    public Employee() {}

    public Employee(Long id, String username, String password, String firstName, String lastName, String email, Role role, String numberPhone, LocalDate dateEmbauche) {
        super(id, username, password, firstName, lastName, email, role, numberPhone);
        this.dateEmbauche = dateEmbauche;
    }


}
