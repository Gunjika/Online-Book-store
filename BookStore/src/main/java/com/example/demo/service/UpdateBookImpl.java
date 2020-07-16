package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UpdateBookToCartDao;
import com.example.demo.entity.ShoppingCart;

@Service
public class UpdateBookImpl implements UpdateBookToCartService{

	@Autowired
	UpdateBookToCartDao dao;

	@Override
	public boolean addBookToCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		ShoppingCart cart=dao.save(shoppingCart);
		if(cart!=null) {
			return true;
		}
		else
			return false;
	}
	
	@Override
	public boolean updateBookToCart(ShoppingCart shoppingCart, int id) {
		// TODO Auto-generated method stub
		shoppingCart.setBookName(shoppingCart.getBookName());
		return dao.save(shoppingCart)!=null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		dao.deleteAll();
		
	}

}
