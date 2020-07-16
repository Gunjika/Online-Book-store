package com.capgemini.oms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.oms.entity.Book;
import com.capgemini.oms.repository.BookRepository;

@Service
public class BookServiceImpl  implements BookService{
	@Autowired
    private BookRepository bookRepository;

	@Override
	public Book findOne(int i) {
		// TODO Auto-generated method stub
		return bookRepository.findById(i).get();
	}

	

}
