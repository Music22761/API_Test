package com.example.ExampleAPI.student.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ExampleAPI.student.json.StudentIDCardListJson;
import com.example.ExampleAPI.student.model.Book;
import com.example.ExampleAPI.student.model.StudentIDCard;
import com.example.ExampleAPI.student.payload.BookPayload;
import com.example.ExampleAPI.student.payload.StudentIDCardPayload;
import com.example.ExampleAPI.student.service.StudentIDCardService;

@Service
public class StudentIDCardBusiness {

	@Autowired
	StudentIDCardService studentIdCardService;
	
	public List<StudentIDCardListJson> getListStudentIdCard(){
		return StudentIDCardListJson.packJsons(studentIdCardService.findAllStudentIDCards());
	}
	
	public StudentIDCardListJson getStudentIdCardByStudentId(long id){
		return StudentIDCardListJson.packJson(studentIdCardService.findByStudentId(id));
	}
	
	public void saveStudentIDCard(StudentIDCardPayload stdIdCardPayload) {
		StudentIDCard stdIdCard = new StudentIDCard(stdIdCardPayload.getStudent_id(),stdIdCardPayload.getCard_number());
		studentIdCardService.save(stdIdCard);
	}

	public void updateStudentIdCard(long id, StudentIDCardPayload payload) {
		StudentIDCard stdIdCard = studentIdCardService.findById(id);
		stdIdCard.setStudent(payload.getStudent_id());
		stdIdCard.setCardNumber(payload.getCard_number());
		studentIdCardService.save(stdIdCard);
		
	}

	public Object getStudentIdCard(long id) {
		// TODO Auto-generated method stub
		return StudentIDCardListJson.packJson(studentIdCardService.findByStudentId(id));
	}
}
