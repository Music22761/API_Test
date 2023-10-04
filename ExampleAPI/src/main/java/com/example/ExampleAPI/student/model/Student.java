package com.example.ExampleAPI.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@Entity(name="Student")
@Table(
		name = "student",
		uniqueConstraints = {
				@UniqueConstraint(name = "student_email_unique",columnNames = "email")
		}
)
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "firstName", nullable = false)
	private String firstName;
	
	@Column(name = "lastName", nullable = false)
	private String lastName;
	
	@Column(name = "email",unique = true, nullable = false)
	private String email;
	
	@Column(name = "age", nullable = false)
	private Integer age;
	
	
	
	
	
	public Student() {
		;
	}
	
	public Student(String firstName, String lastName, String email, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
	}
	
}
