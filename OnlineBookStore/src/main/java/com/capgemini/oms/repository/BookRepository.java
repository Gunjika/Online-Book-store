package com.capgemini.oms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.oms.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
