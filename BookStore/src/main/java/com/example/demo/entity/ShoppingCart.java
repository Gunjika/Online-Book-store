package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "Shopping")
public class ShoppingCart {
	@Id
	@Column(name="cartId")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="cart_seq")
	@SequenceGenerator(sequenceName="cart_seq",initialValue=1010,allocationSize=1,name="cart_seq")
	private int cartId;
	
	
	private String bookName;
	private Integer book_Id;
	private int quantity;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Integer getBook_Id() {
		return book_Id;
	}
	public void setBook_Id(Integer book_Id) {
		this.book_Id = book_Id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ShoppingCart [cartId=" + cartId + ", bookName=" + bookName + ", book_Id=" + book_Id + ", quantity="
				+ quantity + "]";
	}
	public ShoppingCart(int cartId, String bookName, Integer book_Id, int quantity) {
		super();
		this.cartId = cartId;
		this.bookName = bookName;
		this.book_Id = book_Id;
		this.quantity = quantity;
	}
	public ShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
