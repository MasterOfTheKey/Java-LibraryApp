/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masterkey.library.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author francesco
 */
public class Book implements Comparable{
    private long id;
    private String isbn;
    private String title;
    private BigDecimal price;
    private List authors;
    private Pubblisher pubblisher;
    private ArrayList<BookCategory> bookCategories;
    
    private static final Logger log = LoggerFactory.getLogger(Book.class);
    
    public Book(long id, String isbn, String title, ArrayList<Author> authors) {
    	this(id,isbn,title,new BigDecimal("0.00"),authors,null);
        this.bookCategories = new ArrayList<BookCategory>();
        /*this.id = id;
        this.title = title;
        this.authors = authors;
        this.price = new BigDecimal("0.00");*/
    }
    public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Book(long id, String isbn, String title, BigDecimal price, ArrayList<Author> author) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.authors = author;
        this.bookCategories = new ArrayList<BookCategory>();
    }
    public Book(long id, String isbn, String title, BigDecimal price, ArrayList<Author> author, Pubblisher pubblisher) {
	this.id = id;
	this.isbn = isbn;
	this.title = title;
	this.price = price;
	this.authors = author;
	this.pubblisher = pubblisher;
        this.bookCategories = new ArrayList<BookCategory>();
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ArrayList<Author> getAuthor() {
        return (ArrayList<Author>) authors;
    }

    public void setAuthors(ArrayList<Author> author) {
        this.authors = author;
    }
    
    public void addAuthor(Author author) {
    	authors.add(author);
    }
    
    public void addCategory(int category){
    	BookCategory newBookCategory;
    	switch(category) {
    	case 1:
    		newBookCategory = BookCategory.valueOf("ADVENTURE");
    		break;
    	case 2:
    		newBookCategory = BookCategory.valueOf("THRILLER");
    		break;
    	case 3:
    		newBookCategory = BookCategory.valueOf("SCI_FI");
    		break;
    	default:
    		newBookCategory = BookCategory.valueOf("NULL");
    	}
        bookCategories.add(newBookCategory);
    }
    public String getCategories(){
        StringBuilder strBuilder = new StringBuilder();
        for(BookCategory b : bookCategories){
            strBuilder.append(b.getCategory()+ " ");
        }
        return strBuilder.toString();
    }
    public boolean isWrittenBy(Author author) {
    	for(Author bookAuthor : this.getAuthor()) {
    		if(bookAuthor.hashCode() != author.hashCode()) continue;
    		if(bookAuthor.equals(author))return true;
    	}
    	return false;
    }
    
    private String getAuthorsArrayToString() {
    	StringBuilder stringBuilder = new StringBuilder();
    	Iterator it = authors.iterator();
    	while(it.hasNext()) {
    		stringBuilder.append(it.next().toString());
    	}
    	return stringBuilder.toString();
    }
    
    @Override
    public String toString() {
            return "Book id=" + id + "\ntitle=" + title + "\nprice=" + price + "\nauthors=" + getAuthorsArrayToString()
				+ "\npubblisher=" + pubblisher.toString() + "\ncategories="+getCategories();
    }
	@Override
	public int compareTo(Object o) {
		Book book = (Book) o;
		return (int) (this.getId()-book.getId());
	}
	@Override
	public boolean equals(Object o) {
		Book book = (Book) o; 
		return (this.id == book.id);
	}
	@Override
	public int hashCode() { 
		return Long.hashCode(this.id);
	}
	
    
    
}
