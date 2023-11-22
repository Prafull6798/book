package com.java.spring.services;

import java.util.List;

import com.java.spring.entity.Book;

public interface BookServices {
	
	public Book createBook(Book book);
	public List<Book> getBooks();
	public Book searchBook(int bookId);
	public Book updateBook(Book book, int bookId);
	public boolean deleteBook(int bookId);

}
