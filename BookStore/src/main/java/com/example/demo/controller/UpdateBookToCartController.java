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
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins="http://localhost:4200")
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
	
	@PutMapping("/updateCart/{book_Id}")
	public ResponseEntity updateCart(@Validated @RequestBody ShoppingCart shoppingCart,@PathVariable Integer book_Id,BindingResult br)throws CartException
	{
		String err = "";
		if (br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new CartException(err);
		}
		try {
			service.updateCart(shoppingCart, book_Id);
			return new ResponseEntity<String>("Cart Updated", HttpStatus.OK);
		}catch (DataIntegrityViolationException ex) {
			throw new CartException("Already exists");			
		}
	}
	@GetMapping("/Cart/{userId}")
	public Optional<ShoppingCart> getUser(@PathVariable("userId") int userId) {
		Optional<ShoppingCart> cart=service.getBookById(userId);
		return cart;
		
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
