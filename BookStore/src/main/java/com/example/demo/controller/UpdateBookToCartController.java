package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.ShoppingCart;
import com.example.demo.exception.CartException;
import com.example.demo.service.UpdateBookToCartService;

@RestController
public class UpdateBookToCartController {
	@Autowired
	UpdateBookToCartService service;
	
	@PostMapping("/AddToCart")
	public ResponseEntity<String> addBookToCart(@Validated @RequestBody ShoppingCart shoppingCart, BindingResult bindingResult)
			throws CartException {
		String err = "";
		if (bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new CartException(err);
		}
		try {
			service.addBookToCart(shoppingCart);
			return new ResponseEntity<String>("book added successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new CartException("book ID already exists");
		}
	}
	@DeleteMapping("/RemoveAll")
	public String deleteAll() {
		service.deleteAll();
		return "Successfully deleted all enitities";
	}
//	@PutMapping("/updateCart/{id}")
//	public ResponseEntity<String> updateCart(@Validated @RequestBody ShoppingCart shoppingCart, @PathVariable int id,BindingResult bindingResult)throws CartException
//	{
//		String err = "";
//		if (bindingResult.hasErrors()) {
//			List<FieldError> errors = bindingResult.getFieldErrors();
//			for (FieldError error : errors)
//				err += error.getDefaultMessage() + "<br/>";
//			throw new CartException(err);
//		}
//		try
//		{
//			service.updateBookToCart(shoppingCart, id);
//			return new ResponseEntity<String>("Cart updated successfully", HttpStatus.OK);
//
//		}
//		catch (DataIntegrityViolationException ex) {
//			throw new CartException("ID doesnot exists");
//		}
//	}
//	@PutMapping("/updateCart")
//	public ShoppingCart updateC(@RequestBody ShoppingCart shoppingCart) {
//		return service.updateCart(shoppingCart);		
//	}
	
	@PutMapping("/updateCart")
	public ResponseEntity<String> updateCart(@Validated @RequestBody ShoppingCart shoppingCart,BindingResult bindingResult)throws CartException
	{
		String err = "";
		if (bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new CartException(err);
		}
		try
		{
			service.updateCart(shoppingCart);
			return new ResponseEntity<String>("Cart updated successfully", HttpStatus.OK); 
			
		}
		catch (DataIntegrityViolationException ex) {
			throw new CartException("ID doesnot exists");
		}
	}
	@GetMapping("/Cart/{book_Id}")
	public Optional<ShoppingCart> getCategory(@PathVariable("book_Id") int book_Id) {
		Optional<ShoppingCart> cat=service.getBookById(book_Id);
		return cat;
		
	}
	
	@GetMapping("/GetAllBook")
	public ResponseEntity<List<ShoppingCart>> getAllBook() {
		List<ShoppingCart> booklist = service.getAllBook();
		return new ResponseEntity<List<ShoppingCart>>(booklist, HttpStatus.OK);
		
	}
	@DeleteMapping(path="/deleteBook/{book_Id}")
	public ResponseEntity<String> removeBook(@PathVariable int book_Id) {
		
		ResponseEntity<String> res =  new ResponseEntity<String>(service.removeBook(book_Id),HttpStatus.OK);
		
		return res;
	} 
	

}
