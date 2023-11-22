package com.java.spring.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.spring.entity.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional  //  It allows us to set propagation, isolation, timeout, read-only, and rollback conditions for our transaction
public class BookServicesDaoImpl implements BookServicesDao {

	/*
	 * The persistence context is the first-level cache where all the entities are fetched from the 
	 * database or saved to the database.
	 * Persistence context keeps track of any changes made into a managed entity. 
	 * If anything changes during a transaction, then the entity is marked as dirty. 
	 * When the transaction completes, these changes are flushed into persistent storage.
	 */
	@PersistenceContext
	private EntityManager entityManager;
	/*EntityManager API is used to create and remove persistent entity instances, to find entities by their primary key,
	 *  and to query over entities.*/
	
	
	/*
	 *  create new book in database
	 */
	@Override
	public Book addBook(Book book) {
		entityManager.persist(book);    // persist = save
		Book books = getLstInsertedBook();
		return books;
	}
	
	/*
	 * This method will get the latest inserted record from the database and return the object of Book class
	 * return book
	 */
	private Book getLstInsertedBook() {
		String hql = "from Book order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Book book = (Book) query.getSingleResult();
		return book;
	}
	
	/*
	 * This method is responsible to get all books available in database and return it as List<Book>
	 */
	@SuppressWarnings("unchecked")              // instruct the compiler to ignore/suppress, specified compiler warning in annotated element and all program elements inside that element
	@Override
	public List<Book> listBooks() {
		String hql = "FROM Book as atcl ORDER BY atcl.id";
		// String hql = "FROM Book";
		return (List<Book>) entityManager.createQuery(hql).getResultList();
	}
	
	/*
	 * This method is responsible to get Book detail by given book id 
	 */
	@Override
	public Book getBook(int bookId) {
		
		return entityManager.find(Book.class, bookId);
	}

	@Override
	public Book modifyBook(Book book, int bookId) {
		
		//First We are taking Book detail from database by given book id and then updating detail
		Book bookdb = getBook(bookId);
		
		bookdb.setBookName(book.getBookName());
		bookdb.setBookAuthor(book.getBookAuthor());
		bookdb.setBookCategory(book.getBookCategory());
		bookdb.setBookPages(book.getBookPages());
		bookdb.setBookPrice(book.getBookPrice());
		bookdb.setBookPublication(book.getBookPublication());
		
		entityManager.flush();
		
		// taking updated result of book and returning the book object
		Book updatedBook = getBook(bookId);
		
		return updatedBook;
	}

	@Override
	public boolean removeBook(int bookId) {
		Book book = getBook(bookId);
		entityManager.remove(book);
		
		// we are checking here that whether entityManager contains earlier deleted book or not
		// if contains then book is not deleted from DB that's why returning false;
		
		boolean result = entityManager.contains(book);
		if(result==true) {
			return false;
		}
		
		return true;
	}
	

	

}
