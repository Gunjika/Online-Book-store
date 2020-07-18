package com.example.demo.service;

import com.example.demo.entity.ShoppingCart;

public interface UpdateBookToCartService {
	boolean addBookToCart(ShoppingCart ShoppingCart);
	public ShoppingCart updateCart(ShoppingCart shoppingCart);
	void deleteAll();

}
