package com.example.CS545.entity.mid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String city;

    @Size(min = 2,max = 2)
    private String state;


    @Size(min = 5,max = 5)
    private String zipCode;



    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private Student student;

}
