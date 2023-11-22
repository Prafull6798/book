package com.java.spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.spring.entity.Book;
import com.java.spring.services.BookServices;

@RestController
@RequestMapping("/book/api")
public class BookRestController { // http://localhost:8083/api/book/api

	@Autowired
	private BookServices services;
	
	static {
		System.out.println("Book Controller Loaded..");
	}
	
	// http://localhost:8083/api/book/api/book
	@PostMapping("/book")
	public ResponseEntity<?> createBook(@RequestBody Book book){
		
		Book books = services.createBook(book);
		return new ResponseEntity<Book>(books, HttpStatus.OK);
	}
	
	// http://localhost:8083/api/book/api/books
	@GetMapping("/books")
	public ResponseEntity<?> getBooks(){
		List<Book> books = services.getBooks();
		return new ResponseEntity<List<Book>> (books,HttpStatus.OK);
	}
	
	// http://localhost:8083/api/book/api/book/201
	@GetMapping("/book/{id}")
	public ResponseEntity<?> getBookById(@PathVariable("id") Integer id){
		Book book = services.searchBook(id);
		
		return new ResponseEntity<Book> (book,HttpStatus.OK);
	}
	
	// http://localhost:8083/api/book/api/book/update/201
	@PutMapping("/book/update/{id}")
	public ResponseEntity<?> updateBooks(@PathVariable ("id") int id, @RequestBody Book book){
		Book bookdb = services.updateBook(book, id);
		
		return new ResponseEntity<Book> (bookdb, HttpStatus.OK);
	}
	
	// http://localhost:8083/api/book/api/book/delete/201
	@DeleteMapping("/book/delete/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable ("id") int id){
		boolean book = services.deleteBook(id);
		
		if(book) {
			String response = "Book Deleted Successfully";
			return new ResponseEntity<String> (response, HttpStatus.OK);
		}
		String error = "Error in deleting book";
		return new ResponseEntity<String> (error, HttpStatus.OK);
		
	}
	
	
	
	
}
