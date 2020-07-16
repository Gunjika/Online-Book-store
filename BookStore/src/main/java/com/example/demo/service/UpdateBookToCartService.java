package com.example.demo.service;

import com.example.demo.entity.ShoppingCart;

public interface UpdateBookToCartService {
	boolean addBookToCart(ShoppingCart ShoppingCart);
	boolean updateBookToCart(ShoppingCart ShoppingCart,int id);
	void deleteAll();

}
