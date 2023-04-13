package com.example.CS545.entity.mid;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private Float gpa;

    @OneToOne(cascade ={ CascadeType.REMOVE , CascadeType.PERSIST})
    @JoinColumn(name = "address_id")
    private Address address;


    @ManyToMany
    List<Course> courses;
}
