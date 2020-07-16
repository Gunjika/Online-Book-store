package com.capgemini.oms.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int qty;
	private BigDecimal subtotal;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id")
	private Book book;
	
//	
//	@OneToMany(targetEntity =CartItem.class)
//	@JsonIgnore
//	private List<BookToCartItem> bookToCartItemList;
//	
//	@ManyToOne
//	@JoinColumn(name="shopping_cart_id")
//	private ShoppingCart shoppingCart;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(targetEntity=ShoppingCart.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="shopping_cart_id",referencedColumnName = "id")
	private ShoppingCart shoppingCart;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
//
//	public List<BookToCartItem> getBookToCartItemList() {
//		return bookToCartItemList;
//	}
//
//	public void setBookToCartItemList(List<BookToCartItem> bookToCartItemList) {
//		this.bookToCartItemList = bookToCartItemList;
//	}
//
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}


}
