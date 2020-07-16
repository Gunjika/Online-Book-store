package com.capgemini.oms.service;

import java.util.List;

import com.capgemini.oms.entity.Book;
import com.capgemini.oms.entity.CartItem;
import com.capgemini.oms.entity.ShoppingCart;
import com.capgemini.oms.entity.User;

public interface CartItemService {
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

    CartItem updateCartItem(CartItem cartItem);

    CartItem addBookToCartItem(Book book, User user, int qty);

    CartItem findById(Long id);

    void removeCartItem(CartItem cartItem);

    CartItem save(CartItem cartItem);


}
