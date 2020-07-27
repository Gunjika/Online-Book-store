package com.capgemini.oms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class cartItems {
	@Id
	@GeneratedValue
	private int id;
	private String bookname;
	private int quantity;
	private String username;
	@ManyToOne
	private Book book;

	private double subTotal;

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	@Override
	public String toString() {
		return "cartItems [id=" + id + ", bookname=" + bookname + ", quantity=" + quantity + ", username=" + username
				+ ", book=" + book + ", subTotal=" + subTotal + "]";
	}
	
	
	

}
