package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.UpdateBookToCartDao;
import com.example.demo.entity.ShoppingCart;
import com.example.demo.service.UpdateBookToCartService;
@RunWith(SpringRunner.class)	
@SpringBootTest
class BookStoreApplicationTests {
	@Autowired
	private UpdateBookToCartService service;
	
	@MockBean
    UpdateBookToCartDao dao;
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	

	@Test
	void contextLoads() {
	}
	@Test
	public void getAllBookTest() {
		List<ShoppingCart> bookinfo=new ArrayList<ShoppingCart>();
		bookinfo.add(new ShoppingCart("1011", 2021, 1));
		bookinfo.add(new ShoppingCart("1012", 2022, 5));

		when(dao.findAll()).thenReturn(bookinfo);
		List<ShoppingCart> result = service.getAllBook();
		assertEquals(2, result.size());
		
	}
  
	@Test
	public void UpdateBookTest() {
		ShoppingCart c=new ShoppingCart("1011", 2021, 2);
		c.setQuantity(3);
		service.updateCart(c);
		assertEquals(3,c.getQuantity());
	}

	 @Test
	 public void removeBookTest(){
	 ShoppingCart c=new ShoppingCart("1011", 2021, 2);
	 dao.delete(c);
        verify(dao,times(1)).delete(c);
	 }

}
