package com.example.ExampleAPI.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name="Course")
@Table(
		name = "course"
)

public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "course_name", nullable = false)
	private String courseName;
	
	@Column(name = "department", nullable = false)
	private String department;

	
	
	public Course(String courseName, String department) {
		super();
		this.courseName = courseName;
		this.department = department;
	}



	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
