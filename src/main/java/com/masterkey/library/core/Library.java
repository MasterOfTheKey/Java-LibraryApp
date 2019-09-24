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

    Book libraryBookArray[];
    Scanner keyboardScanner;

    public Library() {
        this.libraryBookArray = new Book[0];
        this.keyboardScanner = new Scanner(System.in);
    }
    
    public void start() {
        boolean opDone = false;
        while (!opDone) {
            System.out.print("TheLibrary GUI\n"
                    + "#SELECT OPERATION#\n"
                    + "[1] add book\n"
                    + "[2] delete book\n"
                    + "[3] modify book\n"
                    + "[4] add author\n"
                    + "[5] add pubblisher\n"
                    + "[6] print library stock\n"
                    + "[7] close application\n"
                    + "press number and enter >>");
            switch (keyboardScanner.nextLine()) {
                case "1":
                    getBookInfos();
                    break;
                case "2":
                    deleteBook();
                    break;
                case "3":
                    //modifyBook();
                    System.out.println("Error: service unavaible");
                    break;
                case "4":
                    //modifyBook();
                    System.out.println("Error: service unavaible");
                    break;
                case "5":
                    //modifyBook();
                    System.out.println("Error: service unavaible");
                    break;
                case "6":
                    System.out.println(this.toString());
                    break;
                case "7":
                    opDone = true;
                    System.out.println("see you soon!");
                    break;
                    
                default:
                    System.out.println("Error: command does not exist!");
                    break;
            }
        }
    }

    private void getBookInfos() {
        long id = 0;
        String title = "";
        Author author[] = new Author[0];
        BigDecimal price = new BigDecimal("0.00");
        Pubblisher pubblisher = null;
        id = generateId();
        title = getTitleForNewBook();
        price = getPriceForNewBook();
        author = getAuthorForNewBook();
        pubblisher = getPubblisherForNewBook();
        addBook(id,title,price,author,pubblisher);
    }
    private void addBook(long newId, String newTitle, BigDecimal newPrice, Author[] newAuthor, Pubblisher newPubblisher) {
    	Book newBookArray[] = null;
    	if(libraryBookArray.length==0) {
        	newBookArray = new Book[] {new Book(newId,newTitle,newPrice,newAuthor,newPubblisher)};
        }
        else{
        	newBookArray = new Book[libraryBookArray.length+1];
        	for(int i = 0; i<libraryBookArray.length; i++) {
        		newBookArray[i] = libraryBookArray[i];
        	}
        	newBookArray[newBookArray.length-1] = new Book(newId,newTitle,newPrice,newAuthor,newPubblisher);
        }
        libraryBookArray = newBookArray;
    }
    
    private Pubblisher getPubblisherForNewBook() {
    	String pubblisherName = "";
    	String pubblisherIdAsString = "";
    	long pubblisherId = 0;
    	boolean opDone = false;
    	while(!opDone) {
    		System.out.print("pubblisher id (NO STRINGS!): ");
    		pubblisherIdAsString = keyboardScanner.nextLine();
    		if(!pubblisherIdAsString.isBlank()) {
    			pubblisherId = Long.parseLong(pubblisherIdAsString);
    			System.out.print("pubblisher name: ");
        		pubblisherName = keyboardScanner.nextLine();
        		if(!pubblisherName.isBlank()) {
        			break;
        		}
    		}
    		System.out.println("Error: can\'t input blank values!");
    	}
    	return new Pubblisher(pubblisherId,pubblisherName);
    }
    private BigDecimal getPriceForNewBook(){
        boolean opDone = false;
        BigDecimal newBookPrice = new BigDecimal("0.00");
        while(!opDone){
            System.out.print("want to add price?[Y/N] (default value is set to 0.0)");
            String response = keyboardScanner.nextLine();
            if ("N".equals(response)) {
                newBookPrice = BigDecimal.ZERO;
                opDone = true;
            } else if("Y".equalsIgnoreCase(response)) {
                newBookPrice = getPriceFromInput();
                opDone = true;
            }
            else{
                System.out.println("Can\'t use a blank answer!");
            }
        }
        return newBookPrice;
    }
    private BigDecimal getPriceFromInput(){
        boolean inputOK = false;
        String priceToString = "";
        while(!inputOK){
            System.out.print("PRICE FORMAT xx.xx \nbook price: ");
            priceToString = keyboardScanner.nextLine();
            for(char c : priceToString.toCharArray()){
                if (Character.isAlphabetic(c)){
                    System.out.println("Error: Only numbers allowed!!");
                    break;
                }
                else if (c == ','){
                    System.out.println("Error: Only dots allowed!!");
                    break;
                }
                else{
                    inputOK = true;
                }
            }
        }
        return new BigDecimal(priceToString);
    }
    private String getTitleForNewBook(){
        boolean opDone = false;
        String newBookTitle = "";
        while(!opDone){
            System.out.print("book title: ");
            newBookTitle = keyboardScanner.nextLine();
            if(newBookTitle.isBlank()){
                System.out.println("Error: can\'t use blank spaces");
            }
            else{
                opDone = true;
            }
        }
        return newBookTitle;
    }
    private Author[] getAuthorForNewBook(){
        boolean opDone = false;
        Author authorsArray[] = new Author[1];
        String newAuthorsName = "";
        String newAuthorsSurname = "";
        String newAuthorsIdAsString = "";
        while(!opDone){
            System.out.print("book author\'s name: ");
            newAuthorsName =  keyboardScanner.nextLine();
            System.out.print("book author\'s surname: ");
            newAuthorsSurname =  keyboardScanner.nextLine();
            System.out.print("book author id: ");
            newAuthorsIdAsString =  keyboardScanner.nextLine();
            if(newAuthorsName.isBlank() || newAuthorsSurname.isBlank() || newAuthorsIdAsString.isBlank()){
                System.out.println("Error: can\'t use blank spaces");
            }
            else{
            	if(authorsArray.length == 1) authorsArray[0] = new Author(Long.parseLong(newAuthorsIdAsString),newAuthorsName,newAuthorsSurname);
                System.out.print("Add another author? (Y/N): ");
            	if(keyboardScanner.nextLine().equals("N")) {
                	opDone = true;
                }
                Author newAuthorsArray[] = new Author[authorsArray.length+1];
                for(int i = 0; i<authorsArray.length; i++) {
                	newAuthorsArray[i] = authorsArray[i];
                }
                newAuthorsArray[newAuthorsArray.length-1] = new Author(Long.parseLong(newAuthorsIdAsString),newAuthorsName,newAuthorsSurname);
                authorsArray = newAuthorsArray;
            }
        }
        return authorsArray;
    }
    
    private void deleteBook() {
        String titleToDelete = "";
        String authorToDelete = "";
        boolean opDone = false;
        while (!opDone) {
            System.out.print("#SELECT OPERATION#\n"
                    + "[1] delete by book title\n"
                    + "[2] delete by book author\n"
                    + "[3] close application\n"
                    + "press number and enter >>");
            switch (keyboardScanner.nextLine()) {
                case "1":
                    deleteByBookTitle();
                    break;
                case "2":
                    //deleteByAuthorName();
                    System.out.println("Error: service not available!");
                    break;
                case "3":
                    opDone = true;
                    System.out.println("exiting menu!");
                    break;
                default:
                    System.out.println("Error: Command not found");
                    break;
            }
        }
    }
    private void deleteByBookTitle(){
        boolean opDone = false;
        System.out.println(this.toString());
        while(!opDone){
            String bookTitleToDelete = "";
            System.out.print("delete: ");
            int index = 0;
            bookTitleToDelete = keyboardScanner.nextLine();
            if(bookTitleToDelete.isBlank()){
                System.out.println("Error: title cannot be empty!");
            }
            for(Book book : libraryBookArray){
                if(bookTitleToDelete.equals(book.getTitle())){
                    System.out.println("title found\nDeletion completed!!");
                    Book newBookArray[] =  new Book[libraryBookArray.length-1];
                    for(int i = 0; i<newBookArray.length;i++) {
                    	if(i==index) {
                    		if(libraryBookArray[i+1]!=null) {
                    			newBookArray[i] = libraryBookArray[i+1];
                    		}
                    	}
                    	newBookArray[i] = libraryBookArray[i];
                    }
                    libraryBookArray = newBookArray;
                    opDone = true;
                    break;
                }
                else{
                    System.out.println("Error: book not found!!");
                }
                index++;
            }
        }
        
    }
    /* TODO IMPLEMENT DELETEBYAUTHORNAME FUNCTION
    private void deleteByAuthorName(){
        
    }
    TODO IMPLEMENT MODIFYBOOK FUNCTION
    private void modifyBook() {

    }*/
    private long generateId() {
        long id = 000000000;
        int size = libraryBookArray.length;
        while (size > 0) {
            id++;
            size--;
        }
        return id;
    }

    @Override
    public String toString() {
    	System.out.println(libraryBookArray.length);
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i<libraryBookArray.length;i++) {
            strBuilder.append(libraryBookArray[i].toString() + "\n");
        }
        return (strBuilder.toString());
    }
    
}
