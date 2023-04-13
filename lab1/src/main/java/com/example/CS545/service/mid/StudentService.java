package com.example.CS545.service.mid;

import com.example.CS545.entity.Comment;
import com.example.CS545.entity.dto.CommentDto;
import com.example.CS545.entity.mid.Course;
import com.example.CS545.entity.mid.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Iterable<Student> findAll();

    Optional<Student> getById(Integer id );



    void save(Student c);

    void delete(Integer id);

    void update( Student c);

    Iterable<Course> findCoursesByStudentId(Integer id);

    Iterable<Student> findAllStudetsByGPA(float gpa);

    Iterable<Student> findAllStudetsByCourseAndJpa(String program ,  float gpa);




}
