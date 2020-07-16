package com.capgemini.oms.repository;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.oms.entity.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long>{

}
