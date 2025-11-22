package com.example.collegemanager.Repository;

import com.example.collegemanager.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
