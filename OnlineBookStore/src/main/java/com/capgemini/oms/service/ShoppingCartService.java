package com.capgemini.oms.service;

import com.capgemini.oms.entity.ShoppingCart;

public interface ShoppingCartService {
	 ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);

	    void clearShoppingCart(ShoppingCart shoppingCart);
}
