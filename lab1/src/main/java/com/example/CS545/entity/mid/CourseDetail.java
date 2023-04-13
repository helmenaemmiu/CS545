package com.example.CS545.entity.mid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class CourseDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String descr;
    private int credit;
    private String program;

    private int last_updated;


    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
