package com.example.spring.jpa.repository;

import com.example.spring.jpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;

    @Test
    public void getAllCourses(){
        List<Course> courses = repository.findAll();

        System.out.println(courses);
    }
    
    @Test
    public void getCourses(Pageable pageable){
        PageRequest records_three = PageRequest.of(0, 3, Sort.by("title"));

        List<Course> courses = repository.findAll(records_three).getContent();
    }
}