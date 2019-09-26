/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masterkey.library.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author francesco
 */
public class Library {

    Collection<Book> archive;
    Scanner keyboardScanner;
    File home;
    File archiveFile;
    static final String guiTitle = "Library GUI:";
    static final String deleteTitle = "Delete menu:";
    static final String guiOptions[] = new String[] {"add book","delete book",
    												"print book local archive",
    												"load txt archive to local archive",
    												"upload local archive to txt archive",
    												"exit"};
    static final String deleteOptions[] = new String[] {"delete book by title",
														"delete book by id",
														"exit"};

    public Library() {
        this.archive = new HashSet<Book>();
        this.keyboardScanner = new Scanner(System.in);
        this.home = new File(System.getProperty("user.home"));
        this.archiveFile = new File(home,"archive.txt");
        try {
			this.archiveFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void initializeGui() {
    	boolean done = false;
    	while(!done) {
    		printGuiInterface(guiTitle,guiOptions);
        	String opSelected = keyboardScanner.nextLine();
        	switch(opSelected) {
        	case "1":
        		initializeAddBook();
        		break;
        	case "2":
        		initializeDeleteBook();
        		break;
        	case "3":
        		printArchive();
        		break;
        	case "4":
        		break;
        	case "5":
        		break;
        	case "6":
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
    	System.out.println("NEW BOOK");
    	long id = getIdAsInput();
    	String isbn = getIsbnAsInput();
    	String title = getTitleAsInput();
        BigDecimal price = getPriceAsInput();
        System.out.println("NEW AUTHOR");
        ArrayList<Author> authors = getAuthorsAsInput();
        Pubblisher pubblisher = getPubblisherAsInput();
        addBook(id,isbn,title,price,authors,pubblisher);
    }
    private void initializeDeleteBook() {
    	printDivider();
    	printGuiInterface(deleteTitle, deleteOptions);
    	boolean done = false;
    	while(!done) {
    		String answer = keyboardScanner.nextLine();
        	switch(answer) {
        	case "1":
        		initializeDeleteByTitle();
        		done = true;
        		break;
        	case "2":
        		initializeDeleteById();
        		done = true;
        		break;
        	case "3":
        		done = true;
        		break;
        	default:
        		break;
        	}
    	}
    }
    private void initializeDeleteByTitle() {
    	System.out.println("DELETE BY BOOK");
    	boolean done = false;
    	while(!done) {
    		System.out.print("title to delete>> ");
    		String titleToDelete = keyboardScanner.nextLine();
    		if(deleteBookByTitle(titleToDelete)) {
    			done = true;
    			System.out.println("SUCCESS!");
    			break;
    		}
    		else System.out.print("ERROR: book not found");
    	}
    }
    private void initializeDeleteById() {
    	System.out.println("DELETE BY ID");
    	boolean done = false;
    	while(!done) {
    		long idToDelete = getIdAsInput();
			if(deleteBookById(idToDelete))  {
    			done = true;
    			System.out.println("SUCCESS!");
    			break;
    		}
    		else System.out.print("ERROR: book not found");
    	}
    }
    
    private Pubblisher getPubblisherAsInput() {
    	printDivider();
    	System.out.println("NEW PUBBLISHER");
    	long id = getIdAsInput();
    	boolean done = false;
    	String name = "";
    	while(!done) {
    		System.out.print("pubblisher name>> ");
        	name = keyboardScanner.nextLine();
    		if(inputIsBlank(name)) System.out.println("ERROR: value can\'t be blank");
    		else done = true;
    	}
    	return new Pubblisher(id,name);
    }
    private BigDecimal getPriceAsInput(){
        String priceAsString = "";
        boolean done = false;
        while(!done){
            System.out.print("PRICE >> ");
            priceAsString = keyboardScanner.nextLine();
            if(inputIsBlank(priceAsString) || priceFormatIsCorrect(priceAsString) || isAlphabetic(priceAsString))
                System.out.println("ERROR: price has been inserted wrongfully");
            else done = true;
        }
        return new BigDecimal(priceAsString);
    }
    private ArrayList<Author> getAuthorsAsInput(){
    	printDivider();
        boolean done = false;
        long id = 0;
        String name = "", surname = "";
        ArrayList<Author> authors = new ArrayList<Author>();
        while(!done){
        	id = getIdAsInput();
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
            while(!answerDone){
                System.out.print("add more authors Y/N >> ");
                answer = keyboardScanner.nextLine();
                if(inputIsBlank(answer)) System.out.println("ERROR: the answer must be Y or N");
                else answerDone = true;
            }
            authors.add(new Author(id,name,surname));
            if(!isYes(answer))done=true;
        }
        return authors;
    }
    private String getTitleAsInput() {
        System.out.print("TITLE >> ");
    	return keyboardScanner.nextLine();
    }
    private String getIsbnAsInput() {
    	System.out.print("ISBN CODE >> ");
    	return keyboardScanner.nextLine();
    }
    private long getIdAsInput() {
    	String idAsStr = "";
    	long result = 0;
    	boolean done = false;
    	while(!done) {
    		System.out.print("ID >>");
    		idAsStr = keyboardScanner.nextLine();
        	if(inputIsBlank(idAsStr) || isAlphabetic(idAsStr))System.out.println("ERROR: format not valid");
        	else {
        		result = Long.parseLong(idAsStr);
        		done = true;
        	}
    	}
    	return result;
    }
    
    private boolean isYes(String input){
        return input.equals("Y");
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
   
   
    public void sortByTitle() {
    	BookTitleComparator bookComparator = new BookTitleComparator();
    	Collections.sort((ArrayList)archive, bookComparator);
    }
    public void addBook(long id, String isbn, String title, BigDecimal price, ArrayList<Author> author, Pubblisher pubblisher) {
    	if(!archive.add(new Book(id,isbn,title,price,author,pubblisher))) System.out.println("ERROR: book already exists");
    }
    public void addBook(Book book) {
    	archive.add(book);
    }
    
    
    public boolean deleteBookByTitle(String title){
    	boolean found = false;
        for(Book book : archive){
            if(book.getTitle().equals(title)){
                archive.remove(book);
                found = true;
                break;
            }
        }
        return found;
    }
    public boolean deleteBookById(long id) {
    	boolean found = false;
        for(Book book : archive){
            if(book.getId()==id){
                archive.remove(book);
                found = true;
                break;
            }
        }
        return found;
    }
    
    
    /* TODO: implement txt loading capabilities
    public void loadFromTxtArchive() {
    	try {
			FileReader fileReader = new FileReader(archiveFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			long id = 0;
			String isbn = "", title = "";
			ArrayList<Author> authors = new ArrayList<Author>();
			Pubblisher pubblisher = null;
			BigDecimal price = BigDecimal.ZERO;
			int bookData = 6;
			String text = bufferedReader.readLine();
			while(text!=null) {
				while(bookData>0) {
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    */
    
    public void printArchive(){
        for(Book book : archive){
            System.out.println(book.toString()+"\n");
        }
    }
    
    private void printDivider() {
    	System.out.println("########################");
    }
    private void printGuiInterface(String title, String[] options) {
    	String text = title+"\n";
    	int index = 1;
    	for(String option : options) {
    		text+="["+index+"] "+option+"\n";
    		index++;
    	}
    	text+=">> ";
    	System.out.print(text);
    }
    private void printOptions(String title, String[] options) {
    	StringBuilder strBuilder = new StringBuilder();
    	strBuilder.append(title+"\n");
    	int index = 1;
    	for(String option : options) {
    		strBuilder.append("["+index+"] "+option);
    		index++;
    	}
    	System.out.println(strBuilder.toString());
    }
}
    