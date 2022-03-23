package com.example.spring.jpa.repository;

import com.example.spring.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String name);

    Student findByFirstNameAndLastName(String fname, String lname);

    //JPQL
    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailId(String email);

    //Native Query
    @Query(
            value="SELECT * FROM tbl_student s WHERE s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailId(String email);

    @Query(
            value="SELECT * FROM tbl_student s WHERE s.email_address = :email",
            nativeQuery = true
    )
    Student getStudentByEmailIdNamedParam(@Param("email")String email);

    @Modifying
    @Transactional
    @Query(
            value="UPDATE tbl_student set first_name = ?1 WHERE email_address = ?2",
            nativeQuery = true
    )
    Student updateFirstNameByEmailId(String fname, String email);
}
