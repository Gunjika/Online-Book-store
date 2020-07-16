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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ShoppingCart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private BigDecimal GrandTotal;
	
//	@OneToMany(cascade = CascadeType.ALL, targetEntity = CartItem.class, fetch = FetchType.EAGER)
//	@JoinColumn(name = "cart_id", referencedColumnName = "id")
//	@JsonIgnore
//	private List<CartItem> cartItemList;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getGrandTotal() {
		return GrandTotal;
	}

	public void setGrandTotal(BigDecimal grandTotal) {
		GrandTotal = grandTotal;
	}

//	public List<CartItem> getCartItemList() {
//		return cartItemList;
//	}
//
//	public void setCartItemList(List<CartItem> cartItemList) {
//		this.cartItemList = cartItemList;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

}
