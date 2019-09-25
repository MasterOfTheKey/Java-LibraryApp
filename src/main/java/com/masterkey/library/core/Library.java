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
    	System.out.print("NEW BOOK");
    	long id = getIdAsInput();
    	String title = getTitleAsInput();
        double price = getPriceAsInput();
        System.out.println("NEW AUTHOR");
        ArrayList<Author> authors = getAuthorsAsInput();
    }
    private double getPriceAsInput(){
        String priceAsString = "";
        boolean done = false;
        while(!done){
            System.out.print("PRICE >> ");
            priceAsString = keyboardScanner.nextLine();
            if(inputIsBlank(priceAsString) || priceFormatIsCorrect(priceAsString) || isAlphabetic(priceAsString))
                System.out.println("ERROR: price has been inserted wrongfully");
            else done = true;
        }
        return Double.parseDouble(priceAsString);
    }
    
    private ArrayList<Author> getAuthorsAsInput(){
        boolean done = false;
        String idAsString = "", name = "", surname = "";
        ArrayList<Author> authors = new ArrayList<Author>();
        while(!done){
            boolean idDone = false;
            while(!idDone){
                System.out.print("ID >> ");
                idAsString = keyboardScanner.nextLine();
                if(inputIsBlank(idAsString) || isAlphabetic(idAsString)) 
                    System.out.println("ERROR: ID has been inserted wrongfully");
                else idDone = true;
            }
            boolean nameDone = false;
            while(!nameDone){
                System.out.print("name >> ");
                name = keyboardScanner.nextLine();
                if(inputIsBlank(name)) 
                    System.out.println("ERROR: name has been inserted wrongfully");
                else nameDone = true;
            }
            boolean surnameDone = false;
            while(!surnameDone){
                System.out.print("surname >> ");
                surname = keyboardScanner.nextLine();
                if(inputIsBlank(surname)) 
                    System.out.println("ERROR: name has been inserted wrongfully");
                else surnameDone = true;
            }
            boolean answerDone = false;
            String answer = "";
            while(answerDone){
                System.out.print("add more authors Y/N >> ");
                answer = keyboardScanner.nextLine();
                if(!inputIsBlank(answer)) answerDone = true;
                else System.out.println("ERROR: the answer must be Y or N");
            }
            if(isYes(answer)){
                authors.add(new Author(Long.parseLong(idAsString),name,surname));
            }
        }
        return authors;
    }
    private String getTitleAsInput() {
        System.out.print("TITLE >> ");
    	return keyboardScanner.nextLine();
    }
    private long getIdAsInput() {
        System.out.println("ID >>"); 
    	String idAsStr = "";
    	long result = 0;
    	boolean done = false;
    	while(!done) {
    		idAsStr = keyboardScanner.nextLine();
        	if(inputIsBlank(idAsStr) || isAlphabetic(idAsStr))System.out.println("ERROR: format not valid");
        	else {
        		result = Long.parseLong(idAsStr);
        	}
    	}
    	return result;
    }
    private boolean isYes(String input){
        return input.equals('Y');
    }
    private boolean inputIsBlank(String input) {
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
    