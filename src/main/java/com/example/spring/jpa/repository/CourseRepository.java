package com.example.spring.jpa.repository;

import com.example.spring.jpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
//    List<Course> findAll(Pageable pageable);
}
