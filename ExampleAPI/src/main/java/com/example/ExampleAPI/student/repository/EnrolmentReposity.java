package com.example.ExampleAPI.student.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ExampleAPI.student.model.Enrolment;

@Repository
public interface EnrolmentReposity extends JpaRepository<Enrolment, Long> {

	Enrolment findById(long id);
	Enrolment findByStudentId(long id);
	Enrolment findByCourseId(long id);
	Optional<Enrolment> findEnrolmentById(long id);
	
}
