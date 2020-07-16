package com.capgemini.oms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.oms.entity.Book;

public interface BookRepository  extends CrudRepository<Book, Integer> {
//    List<Book> findByCategory(String category);

    List<Book> findByTitleContaining(String title);
}
