package com.capgemini.oms.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.oms.entity.cartItems;
import com.capgemini.oms.repository.CartRepository;
import com.capgemini.oms.service.CartService;

@RestController
public class CartController {
	@Autowired
	CartService service;

	@Autowired
	CartRepository cartReo;
	@PostMapping("/addToCart/{bookId}")
	public cartItems addToCart(@PathVariable int bookId, @ModelAttribute cartItems items,String username, int quantity){

	    //to save to cartItem table.
		return service.addToCart(bookId, items, username, quantity);

//	    return "books";
	}

//	@GetMapping("/myCart")
//	public  String myCart ( @AuthenticationPrincipal Principal principal, Model model){
//
//	   List<CartItems> cartItems =  cartService.myCart(principal.getName());
//	   model.addAttribute("cartItems",cartItems);
//	    return "myCart";
//	}
	@GetMapping("/myCart")
	public cartItems findByUsername(@RequestParam("username") String username) {
	    return cartReo.findByUsername(username);
	}
}
