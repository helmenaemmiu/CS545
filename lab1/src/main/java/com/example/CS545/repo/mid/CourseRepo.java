package com.example.CS545.repo.mid;

import com.example.CS545.entity.mid.Course;
import com.example.CS545.entity.mid.Student;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepo extends CrudRepository<Course, Integer> {
}
