package com.youcode.resourcium.Entities;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tache")

public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "deadline")
    private Date deadline;

    @Column(name = "priority")
    private String priority;

    @ManyToOne
    @JoinColumn(name = "assigned_employee_id")
    private Employee assignedEmployee;

    @Column(name = "status")
    private String status;



    public Tache(){}

    public Tache(int id, String description, Date deadline, String priority, Employee assignedEmployee, String status) {
        this.id = id;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
        this.assignedEmployee = assignedEmployee;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tache{" +
                "description='" + description + '\'' +
                ", deadline=" + deadline +
                ", priority='" + priority + '\'' +
                ", assignedEmployee=" + assignedEmployee +
                ", status='" + status + '\'' +
                '}';
    }
}
