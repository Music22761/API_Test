package com.example.ExampleAPI.student.payload;

import com.example.ExampleAPI.student.model.Course;
import com.example.ExampleAPI.student.model.Student;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnrolmentPayload {

	private Course course_id;
	private Student student_id;
	private String created_at;
}
