/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masterkey.library.core;

import java.math.BigDecimal;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author francesco
 */
public class Book {
    private long id;
    private String title;
    private BigDecimal price;
    private Author[] authors;
    private Pubblisher pubblisher;
    
    private static final Logger log = LoggerFactory.getLogger(Book.class);
    
	public Book(long id, String title, Author[] authors) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.price = new BigDecimal("0.00");
    }
    public Book(long id, String title, BigDecimal price, Author[] author) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.authors = author;
    }
    public Book(long id, String title, BigDecimal price, Author[] author, Pubblisher pubblisher) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.authors = author;
		this.pubblisher = pubblisher;
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

    public Author[] getAuthor() {
        return authors;
    }

    public void setAuthors(Author[] author) {
        this.authors = author;
    }
    
    public void addAuthor(Author author) {
    	int oldAuthorsArrayLength = authors.length;
    	Author newAuthorsArray[] = new Author[oldAuthorsArrayLength+1];
    	for(int i = 0; i<authors.length; i++) {
    		newAuthorsArray[i] = authors[i]; 
    	}
    	newAuthorsArray[newAuthorsArray.length-1] = author;
    	authors = newAuthorsArray;
    }
    
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", price=" + price + ", authors=" + getAuthorsArrayToString()
				+ ", pubblisher=" + pubblisher.toString() + "]";
	}

    private String getAuthorsArrayToString() {
    	StringBuilder stringBuilder = new StringBuilder();
    	for(Author a : authors) {
    		stringBuilder.append(a.toString());
    	}
    	return stringBuilder.toString();
    }
    
}
