package com.capgemini.oms.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Book {

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(targetEntity=ShoppingCart.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	private List<CartItem> cartItemList;
	
	@Id
    @Column(name="book_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(sequenceName = "book_sequence", allocationSize = 1, name = "book_seq")
	 private Integer bookId;
    
    @Column(name="title")
	 private String title;
    
    @Column(name="author")
	 private String author;
    
    @Column(name="description")
	 private String description;
    
    
    @Column(name="isbn")
	 private Long isbn;
    
	 
    @Column(name="price")
    private  Float price;
    
    @Column(name="publish_date")
   private LocalDate publishDate;
    
    private int inStockNumber;

	public int getInStockNumber() {
		return inStockNumber;
	}

	public void setInStockNumber(int inStockNumber) {
		this.inStockNumber = inStockNumber;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	
	@Override
	public String toString() {
		return "Book [cartItemList=" + cartItemList + ", bookId=" + bookId + ", title=" + title + ", author=" + author
				+ ", description=" + description + ", isbn=" + isbn + ", price=" + price + ", publishDate="
				+ publishDate + ", inStockNumber=" + inStockNumber + "]";
	}

	public Book(List<CartItem> cartItemList, Integer bookId, String title, String author, String description, Long isbn,
			Float price, LocalDate publishDate, int inStockNumber) {
		super();
		this.cartItemList = cartItemList;
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.description = description;
		this.isbn = isbn;
		this.price = price;
		this.publishDate = publishDate;
		this.inStockNumber = inStockNumber;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<CartItem> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}
	
	
	
}