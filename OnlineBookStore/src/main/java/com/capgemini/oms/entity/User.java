package com.capgemini.oms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "user")
public class User {

	@Id

	@Column(name = "user_Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
	@SequenceGenerator(sequenceName = "customer_sequence", allocationSize = 100, name = "customer_seq")
	private Integer userId;

	@Column(name = "FullName")
	private String FullName;

	@Column(name = "Email")
	private String Email;

	@Column(name = "password")
	private String password;

	@Column(name = "PhoneNumber")
	private Long PhoneNumber;

	@Column(name = "city")
	private String city;

	@Column(name = "Address")
	private String Address;

	@Column(name = "ZipCode")
	private String ZipCode;

	@Column(name = "Country")
	private String Country;

	@OneToMany(fetch = FetchType.EAGER, targetEntity = Book.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_Id", referencedColumnName = "user_Id")
	private List<Book> book;

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getZipCode() {
		return ZipCode;
	}

	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shopCart_id")
	private ShoppingCart shoppingCart;

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", FullName=" + FullName + ", Email=" + Email + ", password=" + password
				+ ", PhoneNumber=" + PhoneNumber + ", city=" + city + ", Address=" + Address + ", ZipCode=" + ZipCode
				+ ", Country=" + Country + ", book=" + book + ", shoppingCart=" + shoppingCart + "]";
	}

	public User(Integer userId, String fullName, String email, String password, Long phoneNumber, String city,
			String address, String zipCode, String country, List<Book> bookInfo, ShoppingCart shoppingCart) {
		super();
		this.userId = userId;
		FullName = fullName;
		Email = email;
		this.password = password;
		PhoneNumber = phoneNumber;
		this.city = city;
		Address = address;
		ZipCode = zipCode;
		Country = country;
		book = bookInfo;
		this.shoppingCart = shoppingCart;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
