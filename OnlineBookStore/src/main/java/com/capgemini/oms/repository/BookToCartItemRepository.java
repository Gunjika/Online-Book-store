package com.capgemini.oms.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.oms.entity.BookToCartItem;
import com.capgemini.oms.entity.CartItem;

@Transactional
public interface BookToCartItemRepository extends CrudRepository<BookToCartItem, Long> {
    void deleteByCartItem(CartItem cartItem);
}
