package com.youcode.resourcium.Entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "User")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "numberPhone")
    private String numberPhone;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "date_embauche")
    private LocalDate dateEmbauche;

    @OneToOne
    @JoinColumn(name= "department_id")
    Departement departement;

    @Column(name = "tasks")
    @OneToMany
    @JoinColumn(name = "task")
    private List<Tache> tasks = new ArrayList<>();
    public User(){}

    public User(Long id, String username, String password, String firstName, String lastName, String email, Role role,String numberPhone,LocalDate dateEmbauche) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.numberPhone = numberPhone;
        this.dateEmbauche = dateEmbauche;
    }

    public User(Long id, String username, String password, String firstName, String lastName, String email, Role role,String numberPhone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.numberPhone = numberPhone;
    }

    public User(String firstName, String lastName, String username, Departement department, String email, String password,String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.departement = department;
        this.email = email;
        this.password = password;
        this.numberPhone = phone;
    }

    public User(String john, String password, String john1, String mail, Role role, String number) {
        this.username = john;
        this.password = password;
        this.firstName = john1;
        this.email = mail;
        this.role = role;
        this.numberPhone = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public void addTask(Tache task) {
        this.tasks.add(task);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(numberPhone, user.numberPhone) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, firstName, lastName, email, numberPhone, role);
    }
}
