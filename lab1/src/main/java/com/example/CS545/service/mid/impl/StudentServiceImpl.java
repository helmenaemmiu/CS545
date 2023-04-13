package com.example.CS545.service.mid.impl;

import com.example.CS545.entity.mid.Course;
import com.example.CS545.entity.mid.Student;
import com.example.CS545.repo.mid.StudentRepo;
import com.example.CS545.service.mid.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Iterable<Student> findAll(){
        return studentRepo.findAll();
    }

    @Override
    public Optional<Student> getById(Integer id)
    {
        return studentRepo.findById(id);
    }

    @Override
    public void save(Student c){
         studentRepo.save(c);
    }

    @Override
    public void delete(Integer id){
        studentRepo.deleteById(id);
    }

    @Override
    public void update( Student c)
    {
        studentRepo.save(c);
    }

    @Override
    public Iterable<Course> findCoursesByStudentId(Integer id){
      return   studentRepo.findAllCoursesByStudetId(id);
    }


    @Override
    public Iterable<Student> findAllStudetsByGPA(float gpa){
        return   studentRepo.findAllStudetsByGPA(gpa);
    }

    @Override
    public Iterable<Student> findAllStudetsByCourseAndJpa(String program ,  float gpa){
        return   studentRepo.findAllStudetsByCourseAndJpa(program ,gpa );
    }

}
