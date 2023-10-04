package com.example.ExampleAPI.student.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name="Book")
@Table(
		name = "book"
//		uniqueConstraints = {
//				@UniqueConstraint(name = "student_card_number_unique",columnNames = "card_number")
//		}
)


public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id", nullable = false) //FK
	@Fetch(FetchMode.JOIN)
	private Student student;
	
	@Column(name = "book_name", nullable = false)
	private String bookName;
	
	
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false,
	updatable = false, insertable = false,
	columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private String createdAt;

	
	public Book() {
		;
		// TODO Auto-generated constructor stub
	}
	
	public Book(String bookName,Student student, String createdAt) {
		super();
		this.bookName = bookName;
		this.createdAt = createdAt;
		this.student = student;
	}



	

}
