package com.example.CS545.controller.mid;


import com.example.CS545.entity.mid.Course;
import com.example.CS545.entity.mid.Student;
import com.example.CS545.service.mid.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;
    @GetMapping
    public Iterable<Student>  getAllStudents()
    {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable int id)
    {
        return studentService.getById(id);
    }

    @GetMapping("/coursescode")
    public Iterable<Student> findAllStudetsByCourseAndJpa(@RequestParam("program") String program , @RequestParam("gpa") float gpa)
    {
        System.out.println("dakljsdkajsdkjals");
        return studentService.findAllStudetsByCourseAndJpa(program , gpa);
    }

    @GetMapping("/{id}/courses")
    public Iterable<Course> getStudentCoursesById(@PathVariable int id)
    {
        return studentService.findCoursesByStudentId(id);
    }

    @PostMapping
    public void   createNewStudent(@RequestBody Student student)
    {
        studentService.save(student);
    }

    @PutMapping
    public void updateStudent(@RequestBody Student student)
    {
        studentService.save(student);
    }

    @DeleteMapping("/{id}")
    public void   deleteById(@PathVariable int id)
    {
        studentService.delete(id);
    }
}
