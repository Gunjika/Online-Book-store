package com.capgemini.oms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.oms.entity.Book;
import com.capgemini.oms.entity.cartItems;
import com.capgemini.oms.repository.BookRepository;
import com.capgemini.oms.repository.CartRepository;

@Service
public class CartService {
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	CartRepository cartRepository;

	public cartItems addToCart(int bookId, cartItems items, String username,int quantity){

		Book book = bookRepository.findById(bookId).orElse(null);
		items.setBook(book);

		items.setSubTotal(book.getPrice());
		items.setUsername(username);
		items.setQuantity(quantity);
		return cartRepository.save(items);

		}
		public List<cartItems> myCart(String userName){

		    List<cartItems> items = new ArrayList<>();
		    cartRepository.findByUsername(userName);

		    return items;

}
}
