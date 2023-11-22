package com.java.spring.services;

import java.util.List;

import com.java.spring.entity.Book;

public interface BookServicesDao {
	
	public Book addBook(Book book);
	public List<Book> listBooks();
	public Book getBook(int bookId);
	public Book modifyBook(Book book, int bookId);
	public boolean removeBook(int bookId);

}
