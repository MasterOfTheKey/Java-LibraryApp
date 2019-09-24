/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masterkey.library.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author francesco
 */
public class Library {

    ArrayList<Book> libraryBookArray;
    Scanner keyboardScanner;

    public Library() {
        this.libraryBookArray = new ArrayList<Book>();
        this.keyboardScanner = new Scanner(System.in);
    }
    
    public void addBook(long id, String title, BigDecimal price, Author[] author, Pubblisher pubblisher) {
    	libraryBookArray.add(new Book(id,title,price,author,pubblisher));
    }
    public void deleteBook(long id, String title) {
    	//if(id != null)
    }
}