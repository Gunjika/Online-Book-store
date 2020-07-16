package com.capgemini.oms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.oms.entity.CartItem;
import com.capgemini.oms.entity.ShoppingCart;

@Transactional
public interface CartItemRepository extends CrudRepository<CartItem, Long> {
    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

//    List<CartItem> findByOrder(Order order);
}