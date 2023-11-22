package com.java.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.entity.Book;

@Service
public class BookServiceImpl implements BookServices {

	@Autowired
	private BookServicesDao dao;
	
	@Override
	public Book createBook(Book book) {
	
		return dao.addBook(book);
	}

	@Override
	public List<Book> getBooks() {
		
		return dao.listBooks();
	}

	@Override
	public Book searchBook(int bookId) {
	
		return dao.getBook(bookId);
	}

	@Override
	public Book updateBook(Book book, int bookId) {
		
		return dao.modifyBook(book, bookId);
	}

	@Override
	public boolean deleteBook(int bookId) {

		return dao.removeBook(bookId);
	}

}
