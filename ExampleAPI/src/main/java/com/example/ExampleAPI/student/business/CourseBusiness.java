package com.example.ExampleAPI.student.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ExampleAPI.student.json.BookListJson;
import com.example.ExampleAPI.student.json.CourseListJson;
import com.example.ExampleAPI.student.model.Book;
import com.example.ExampleAPI.student.model.Course;
import com.example.ExampleAPI.student.payload.BookPayload;
import com.example.ExampleAPI.student.payload.CoursePayload;
import com.example.ExampleAPI.student.service.CourseService;

@Service
public class CourseBusiness {

	@Autowired
	CourseService courseService;
	
	public List<CourseListJson> getListCourse(){
		return CourseListJson.packJsons(courseService.findAllCourses());
	}
	
	public CourseListJson getCourseId(long id) {
		return CourseListJson.packJson(courseService.findById(id));
	}
	
	public void saveCourse(CoursePayload coursePayload) {
		Course course = new Course(coursePayload.getCourse_name(),coursePayload.getDepartment());
		courseService.save(course);
	}
	
	public void updateCourse(long id, CoursePayload payload) {
		Course courseData = courseService.findById(id);
		courseData.setCourseName(payload.getCourse_name());
		courseData.setDepartment(payload.getDepartment());
		courseService.save(courseData);
	}
}
