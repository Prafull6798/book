package com.java.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "BOOK")
@Entity
public class Book {
	
	@Id
	@Column(name="id")
	private int bookId;
	
	@Column(name="name")
	private String bookName;
	
	@Column(name="author")
	private String bookAuthor;
	
	@Column(name="publication")
	private String bookPublication;
	
	@Column(name="category")
	private String bookCategory;
	
	@Column(name="pages")
	private int bookPages;
	
	@Column(name="price")
	private int bookPrice;

	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bookId, String bookName, String bookAuthor, String bookPublication, String bookCategory,
			int bookPages, int bookPrice) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPublication = bookPublication;
		this.bookCategory = bookCategory;
		this.bookPages = bookPages;
		this.bookPrice = bookPrice;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookPublication="
				+ bookPublication + ", bookCategory=" + bookCategory + ", bookPages=" + bookPages + ", bookPrice="
				+ bookPrice + "]";
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPublication() {
		return bookPublication;
	}

	public void setBookPublication(String bookPublication) {
		this.bookPublication = bookPublication;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public int getBookPages() {
		return bookPages;
	}

	public void setBookPages(int bookPages) {
		this.bookPages = bookPages;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	
}