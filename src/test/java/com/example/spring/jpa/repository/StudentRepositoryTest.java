package com.example.spring.jpa.repository;

import com.example.spring.jpa.entity.Guardian;
import com.example.spring.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("hulahoop41@gmail.com")
                .firstName("samuel")
                .lastName("Wanjohi")
//                .guardianName("Dad")
//                .guardianEmail("dad@gmail.com")
//                .guardianMobile("0712345678")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = new Guardian("Dad","dad@gmail.com","0712345678");
        Student student = Student.builder()
                .emailId("hulahoop41@gmail.com")
                .firstName("samuel")
                .lastName("Wanjohi")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> list = studentRepository.findAll();
        System.out.println("studentList "+ list);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("samuel");
        System.out.println("studentList "+ students);
    }
}