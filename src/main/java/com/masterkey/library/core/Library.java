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

    ArrayList<Book> archive;
    Scanner keyboardScanner;

    public Library() {
        this.archive = new ArrayList<Book>();
        this.keyboardScanner = new Scanner(System.in);
    }
    
    public void addBook(long id, String title, BigDecimal price, ArrayList<Author> author, Pubblisher pubblisher) {
    	archive.add(new Book(id,title,price,author,pubblisher));
    }
    public void deleteBookByTitle(String title){
        for(Book book : archive){
            if(book.getTitle().equals(title)){
                archive.remove(book);
                break;
            }
        }
    }
    public void deleteBookById(Long id) {
    	for(Book book : archive){
            if(book.getId()==id){
                archive.remove(book);
                break;
            }
        }
    }
    public void printArchive(){
        for(Book book : archive){
            System.out.println(book.toString());
        }
    }
}