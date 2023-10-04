package com.example.ExampleAPI.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ExampleAPI.student.model.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
	Student findById(long id);
	Student findByEmail(String email);
	Optional<Student> findOptionalById(long id);
}
