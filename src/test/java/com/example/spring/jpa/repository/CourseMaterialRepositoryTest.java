package com.example.spring.jpa.repository;

import com.example.spring.jpa.entity.Course;
import com.example.spring.jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository repository;


    @Test
    public void saveCourseMaterial(){
        Course course = new Course("DSA", 10);
        CourseMaterial material = new CourseMaterial("www.dsa.edu", course);

        repository.save(material);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> materials = repository.findAll();
        System.out.println(materials);
    }

}