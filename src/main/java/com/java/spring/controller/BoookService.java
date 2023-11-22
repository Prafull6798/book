package com.java.spring.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.java.spring.entity.Book;


@Service
public interface BoookService extends JpaRepository<Book, Integer> {
	
}
