/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masterkey.library.core;

import java.math.BigDecimal;

/**
 *
 * @author francesco
 */
public class Book {
    private long id;
    private String title;
    private BigDecimal price;
    private String author;
    public Book(long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = new BigDecimal("0.00");
    }
    public Book(long id, String title, BigDecimal price, String author) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", price=" + price + ", author=" + author + '}';
    }
    
}
