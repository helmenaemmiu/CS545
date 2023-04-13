package com.example.CS545.repo.mid;

import com.example.CS545.entity.mid.Course;
import com.example.CS545.entity.mid.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends CrudRepository<Student , Integer> {

    @Query("SELECT s.courses from Student s where s.id = ?1")
    public List<Course> findAllCoursesByStudetId(int id);

    @Query("SELECT s from Student s where s.gpa  <= ?1")
    public List<Student> findAllStudetsByGPA(float gpa);


    @Query("SELECT s from Student s join s.courses c  join  c.courseDetail cd  where cd.program like ?1 and  s.gpa >= ?2  ")
    public List<Student> findAllStudetsByCourseAndJpa(String program ,  float gpa);
}
