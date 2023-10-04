package com.example.ExampleAPI.student.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ExampleAPI.exception.BaseException;
import com.example.ExampleAPI.student.json.BookListJson;
import com.example.ExampleAPI.student.json.EnrolmentListJson;
import com.example.ExampleAPI.student.model.Book;
import com.example.ExampleAPI.student.model.Enrolment;
import com.example.ExampleAPI.student.payload.BookPayload;
import com.example.ExampleAPI.student.payload.EnrolmentPayload;
import com.example.ExampleAPI.student.service.EnrolmentService;

@Service
public class EnrolmentBusiness {

	@Autowired
	EnrolmentService enrolmentService;
	
	public List<EnrolmentListJson> getListEnrolment(){
		return EnrolmentListJson.packJsons(enrolmentService.findALlEnrolments());
	}
	
	public EnrolmentListJson getEnrolmentByStudentId(long id) {
		return EnrolmentListJson.packJson(enrolmentService.findByStudentId(id));
	}
	
	public void saveEnrolment(EnrolmentPayload enrolPayload) {
		Enrolment enrol = new Enrolment(enrolPayload.getCourse_id(),enrolPayload.getStudent_id(),enrolPayload.getCreated_at());
		enrolmentService.save(enrol);
	}

	public void updateEnrolment(long id, EnrolmentPayload payload) {
		Enrolment enrol = enrolmentService.findById(id);
		enrol.setCourse(payload.getCourse_id());
		enrol.setStudent(payload.getStudent_id());
		enrol.setCreatedAt(payload.getCreated_at());
		enrolmentService.save(enrol);
		
	}
	
	
}
