package com.capgemini.oms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class BookToCartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(insertable = false,updatable = false)
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER,targetEntity = BookToCartItem.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Book book;
	
	
	@ManyToOne
	@JoinColumn(name="cart_item_id",referencedColumnName = "id")
	private CartItem cartItem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public CartItem getCartItem() {
		return cartItem;
	}

	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}
	

}
