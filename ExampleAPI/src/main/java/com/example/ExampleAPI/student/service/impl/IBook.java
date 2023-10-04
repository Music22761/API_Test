package com.example.ExampleAPI.student.service.impl;

import java.util.List;

import com.example.ExampleAPI.student.model.Book;


public interface IBook {
	
	List<Book> getAllBooks();
	Book findByIBook(long id);
	Book findByStudentId(long id);
	Book findByBookNameContainBook(String bookName);
	Book save(Book std);
	void deleteById(long id);
	
}
