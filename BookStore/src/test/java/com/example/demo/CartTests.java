package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.dao.UpdateBookToCartDao;
import com.example.demo.entity.ShoppingCart;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CartTests {
	@Autowired
	private UpdateBookToCartDao dao;
	
	@Test
	@Rollback(false)
	public void testCreateBookToCart() {
		ShoppingCart shoppingCart=new ShoppingCart("1011", 1234, 250);
		ShoppingCart saved=dao.save(shoppingCart);
		
		assertNotNull(saved);
	}
//	
//	@Test
//	public void testUpdateCart() {
//		String bookName="Fault in our stars";
//		ShoppingCart shoppingCart=new ShoppingCart(1011, bookName, 4545, 9);
//		shoppingCart.setCartId(1011);
//		dao.save(shoppingCart);
//		
//		ShoppingCart update=dao.findById(cartId);
//		}
	@Test
	@Rollback(false)
	public void testDeleteBook() {
		Integer id=1011;
		boolean p1=dao.findById(id).isPresent();
		dao.deleteById(id);
		boolean p2=dao.findById(id).isPresent();
		
		assertTrue(p1);
		assertTrue(p2);

	}
}
