package com.example.ExampleAPI.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ExampleAPI.exception.BaseException;
import com.example.ExampleAPI.student.business.BookBusiness;
import com.example.ExampleAPI.student.business.CourseBusiness;
import com.example.ExampleAPI.student.business.EnrolmentBusiness;
import com.example.ExampleAPI.student.business.StudentBusiness;
import com.example.ExampleAPI.student.business.StudentIDCardBusiness;
import com.example.ExampleAPI.student.exception.StudentException;
import com.example.ExampleAPI.student.json.BookListJson;
import com.example.ExampleAPI.student.json.CourseListJson;
import com.example.ExampleAPI.student.json.EnrolmentListJson;
import com.example.ExampleAPI.student.json.StudentIDCardListJson;
import com.example.ExampleAPI.student.json.StudentListJson;
import com.example.ExampleAPI.student.model.Book;
import com.example.ExampleAPI.student.model.Course;
import com.example.ExampleAPI.student.model.Enrolment;
import com.example.ExampleAPI.student.model.Student;
import com.example.ExampleAPI.student.model.StudentIDCard;
import com.example.ExampleAPI.student.payload.BookPayload;
import com.example.ExampleAPI.student.payload.CoursePayload;
import com.example.ExampleAPI.student.payload.EnrolmentPayload;
import com.example.ExampleAPI.student.payload.StudentIDCardPayload;
import com.example.ExampleAPI.student.payload.StudentPayload;
import com.example.ExampleAPI.student.service.BookService;
import com.example.ExampleAPI.student.service.CourseService;
import com.example.ExampleAPI.student.service.EnrolmentService;
import com.example.ExampleAPI.student.service.StudentIDCardService;
import com.example.ExampleAPI.student.service.StudentService;

@RestController
@RequestMapping("/api")

public class StudentController {
	
	//Service
	@Autowired
	StudentService studentservice;
	
	@Autowired
	BookService bookservice;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	EnrolmentService enrolmentservice;
	
	@Autowired
	StudentIDCardService stdIdCardService;
	

	
	
	
	//Business
	@Autowired
	StudentBusiness stdBusiness;
	
	@Autowired
	BookBusiness bookBusiness;
	
	@Autowired
	CourseBusiness courseBusiness;
	
	@Autowired
	EnrolmentBusiness enrolmentBusiness;
	
	@Autowired
	StudentIDCardBusiness stdIdCardBusiness;
	
	
	
	
	public StudentController() {
    }
	
	public StudentController(StudentService studentservice) {
		this.studentservice = studentservice;
	}
	
	
	public StudentController(BookService bookservice) {
		this.bookservice = bookservice;
	}
	
	
	
	
	//Insert Data
	@PostMapping(value = "/students")
	public ResponseEntity<Void> saveStudent(@RequestBody StudentPayload payload) throws BaseException{
		stdBusiness.saveStudent(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/books")
	public ResponseEntity<Void> saveBook(@RequestBody BookPayload payload) throws BaseException{
		bookBusiness.saveBook(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/courses")
	public ResponseEntity<Void> saveCourse(@RequestBody CoursePayload payload) throws BaseException{
		courseBusiness.saveCourse(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/enrolments")
	public ResponseEntity<Void> saveEnrolment(@RequestBody EnrolmentPayload payload) throws BaseException{
		enrolmentBusiness.saveEnrolment(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/studentIdCards")
	public ResponseEntity<Void> saveStdIDCard(@RequestBody StudentIDCardPayload payload) throws BaseException{
		stdIdCardBusiness.saveStudentIDCard(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	
	
	
	//get All method
	@GetMapping(value = "/students")
	public ResponseEntity<List<StudentListJson>> getAllStudent() throws BaseException{
		return ResponseEntity.ok(stdBusiness.getListStudent());
	}
	@GetMapping(value = "/books")
	public ResponseEntity<List<BookListJson>> getAllBook() throws BaseException{
		return ResponseEntity.ok(bookBusiness.getListBook());
	}
	@GetMapping(value = "/courses")
	public ResponseEntity<List<CourseListJson>> getAllCourse() throws BaseException{
		return ResponseEntity.ok(courseBusiness.getListCourse());
	}
	@GetMapping(value = "/enrolments")
	public ResponseEntity<List<EnrolmentListJson>> getAllEnrolment() throws BaseException{
		return ResponseEntity.ok(enrolmentBusiness.getListEnrolment());
	}
	@GetMapping(value = "/studentIdCards")
	public ResponseEntity<List<StudentIDCardListJson>> getAllStudentIDCard() throws BaseException{
		return ResponseEntity.ok(stdIdCardBusiness.getListStudentIdCard());
	}
	
	
	//get ID method

	@GetMapping(value = "/students/{id}")
	public ResponseEntity<StudentListJson> getStudentById(@PathVariable("id") long id) throws BaseException{
		return ResponseEntity.ok(stdBusiness.getStudentId(id));
	}
	
	@GetMapping(value = "/students/{id}/card")
	public ResponseEntity<StudentIDCardListJson> getStudentIdCardByStudentId(@PathVariable("id") long id) throws StudentException{
		return ResponseEntity.ok(stdIdCardBusiness.getStudentIdCardByStudentId(id));
	}
	
	@GetMapping(value = "/students/{id}/enrolment")
	public ResponseEntity<EnrolmentListJson> getEnrolmentByStudentId(@PathVariable("id") long id) throws StudentException{
		return ResponseEntity.ok(enrolmentBusiness.getEnrolmentByStudentId(id));
	}
	
	@GetMapping(value = "/students/{id}/book")
	public ResponseEntity<BookListJson> getBookByStudentId(@PathVariable("id") long id) throws StudentException{
		return ResponseEntity.ok(bookBusiness.getBookByStudentId(id));
	}
	
	@GetMapping(value = "/students/{id}/course")
	public ResponseEntity<CourseListJson> getCourseById(@PathVariable("id") long id) throws StudentException{
		return ResponseEntity.ok(courseBusiness.getCourseId(id));
	}
	
	
	
	//Update Data by Id
	
	@PutMapping("/students/{id}")
	public ResponseEntity<StudentListJson> updateStudent(@PathVariable("id") long id,@RequestBody StudentPayload payload) throws BaseException{
		Optional<Student> stdData = studentservice.findOptionalById(id);
		if (stdData.isPresent()) {
			stdBusiness.updateStudent(stdData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/books/{id}")
	public ResponseEntity<StudentListJson> updateBook(@PathVariable("id") long id,@RequestBody BookPayload payload) throws BaseException{
		Optional<Book> book = bookservice.findOptionalById(id);
		if (book.isPresent()) {
			bookBusiness.updateBook(book.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/courses/{id}")
	public ResponseEntity<CourseListJson> updateCourse(@PathVariable("id") long id,@RequestBody CoursePayload payload) throws BaseException{
		Optional<Course> course = courseService.findOptionalById(id);
		if (course.isPresent()) {
			courseBusiness.updateCourse(course.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/enrolments/{id}")
	public ResponseEntity<EnrolmentListJson> updateEnrolment(@PathVariable("id") long id,@RequestBody EnrolmentPayload payload) throws BaseException{
		Optional<Enrolment> enrol = enrolmentservice.findOptionalById(id);
		if (enrol.isPresent()) {
			enrolmentBusiness.updateEnrolment(enrol.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/studentIdCards/{id}")
	public ResponseEntity<StudentIDCardListJson> updateStudentIdCard(@PathVariable("id") long id,@RequestBody StudentIDCardPayload payload) throws BaseException{
		Optional<StudentIDCard> stdIdCard = stdIdCardService.findOptionalById(id);
		if (stdIdCard.isPresent()) {
			stdIdCardBusiness.updateStudentIdCard(stdIdCard.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	//Delete table by ID
	@DeleteMapping("/students/{id}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") long id){
		try {
			stdBusiness.deleteStudent(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
