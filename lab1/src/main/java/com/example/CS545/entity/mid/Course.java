package com.example.CS545.entity.mid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToOne(mappedBy = "course")
    private CourseDetail courseDetail;

    @JsonIgnore
    @ManyToMany(mappedBy = "courses")
    List<Student> students;

}
