package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ShoppingCart;

public interface UpdateBookToCartDao extends JpaRepository<ShoppingCart, Integer>{

}
