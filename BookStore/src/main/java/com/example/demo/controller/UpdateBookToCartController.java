package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@PutMapping("/updateCart/{id}")
	public ResponseEntity<String> updateCart(@Validated @RequestBody ShoppingCart shoppingCart, @PathVariable int id,BindingResult bindingResult)throws CartException
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
			service.updateBookToCart(shoppingCart, id);
			return new ResponseEntity<String>("Cart updated successfully", HttpStatus.OK);

		}
		catch (DataIntegrityViolationException ex) {
			throw new CartException("ID doesnot exists");
		}
	}

}
