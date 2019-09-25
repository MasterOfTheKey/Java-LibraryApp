/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masterkey.library.core;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
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
    File home;
    File archiveFile;

    public Library() {
        this.archive = new ArrayList<Book>();
        this.keyboardScanner = new Scanner(System.in);
        this.home = new File(System.getProperty("user.home"));
        this.archiveFile = new File(home,"archive.txt");
    }
    
    public void initializeGui() {
    	boolean done = false;
    	while(!done) {
    		System.out.print("Library GUI:\n"
        			+ "[1] add book\n"
        			+ "[2] delete book\n"
        			+ "[3] print book local archive\n"
        			+ "[4] load txt archive to local archive\n"
        			+ "[5] upload local archive to txt archive\n"
        			+ "[6] exit"
        			+ ">> ");
        	int opSelected = keyboardScanner.nextInt();
        	switch(opSelected) {
        	case 1:
        		break;
        	case 2:
        		break;
        	case 3:
        		break;
        	case 4:
        		break;
        	case 5:
        		break;
        	case 6:
        		done = true;
        		break;
        	default:
        		System.out.println("ERROR: command not found!");
        		break;
        	}
    	}
    }
    
    private void initializeAddBook() {
    	printDivider();
    	System.out.print("NEW BOOK\nID >> ");
    	long id = getIdAsInput();
    	System.out.print("TITLE >> ");
    	String title = getTitleAsInput();
    	
    }
    private String getTitleAsInput() {
    	return keyboardScanner.nextLine();
    }
    private long getIdAsInput() {
    	String idAsStr = "";
    	long result = 0;
    	boolean done = false;
    	while(!done) {
    		idAsStr = keyboardScanner.nextLine();
        	if(inputIsNull(idAsStr) || isAlphabetic(idAsStr))System.out.print("ERROR: format not valid\n>> ");
        	else {
        		result = Long.parseLong(idAsStr);
        	}
    	}
    	return result;
    }
    private boolean inputIsNull(String input) {
    	return (input.isBlank());
    }
    private boolean priceFormatIsCorrect(String input) {
    	return (input.contains(",") || isAlphabetic(input));
    }
    private boolean isAlphabetic(String input) {
    	for(char c : input.toCharArray()) {
    		if(Character.isAlphabetic(c)) return true;
    	}
    	return false;
    }
    public void addBook(long id, String title, BigDecimal price, ArrayList<Author> author, Pubblisher pubblisher) {
    	archive.add(new Book(id,title,price,author,pubblisher));
    }
    public void addBook(Book book) {
    	archive.add(book);
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
    
    private void printDivider() {
    	System.out.println("########################");
    }
}
    