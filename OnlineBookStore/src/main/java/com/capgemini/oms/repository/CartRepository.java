package com.capgemini.oms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.oms.entity.Book;
import com.capgemini.oms.entity.cartItems;

public interface CartRepository extends JpaRepository<cartItems, Integer>{

	public cartItems findByUsername(String username);

}
