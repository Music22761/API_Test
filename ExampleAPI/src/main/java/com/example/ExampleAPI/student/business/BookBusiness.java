package com.example.ExampleAPI.student.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ExampleAPI.student.json.BookListJson;
import com.example.ExampleAPI.student.json.StudentListJson;
import com.example.ExampleAPI.student.model.Book;
import com.example.ExampleAPI.student.model.Student;
import com.example.ExampleAPI.student.payload.BookPayload;
import com.example.ExampleAPI.student.payload.StudentPayload;
import com.example.ExampleAPI.student.service.BookService;

@Service
public class BookBusiness {

	@Autowired
	BookService bookService;
	
	
	public List<BookListJson> getListBook(){
		return BookListJson.packJsons(bookService.getAllBooks());
	}
	
	public BookListJson getBookByStudentId(long id) {
		return BookListJson.packJson(bookService.findByStudentId(id));
	}
	
	public void saveBook(BookPayload bookPayload) {
		Book book = new Book(bookPayload.getBook_name(),bookPayload.getStudent_id(),bookPayload.getCreated_at());
		bookService.save(book);
	}
	
	public void updateBook(long id, BookPayload payload) {
		Book bookData = bookService.findByIBook(id);
		bookData.setBookName(payload.getBook_name());
		bookData.setStudent(payload.getStudent_id());
		bookData.setCreatedAt(payload.getCreated_at());
		bookService.save(bookData);
	}
}
