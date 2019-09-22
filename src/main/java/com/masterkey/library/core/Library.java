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

    ArrayList<Book> libraryBookList;
    Scanner keyboardScanner;

    public Library() {
        this.libraryBookList = new ArrayList<Book>();
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
                    + "[4] print library stock\n"
                    + "[5] close application\n"
                    + "press number and enter >>");
            switch (keyboardScanner.nextLine()) {
                case "1":
                    addBook();
                    break;
                case "2":
                    deleteBook();
                    break;
                case "3":
                    //modifyBook();
                    System.out.println("Error: service unavaible");
                    break;
                case "4":
                    System.out.println(this.toString());
                    break;
                case "5":
                    opDone = true;
                    System.out.println("see you soon!");
                    break;
                default:
                    System.out.println("Error: Command not found");
                    break;
            }
        }
    }

    private void addBook() {
        String title = "";
        String author = "";
        BigDecimal price = new BigDecimal("0.00");
        long id = generateId();
        title = getTitleForNewBook();
        author = getAuthorForNewBook();
        price = getPriceForNewBook();
        libraryBookList.add(new Book(id,title,price,author));
    }
    private BigDecimal getPriceForNewBook(){
        boolean opDone = false;
        BigDecimal newBookPrice = new BigDecimal("0.00");
        while(!opDone){
            System.out.print("want to add price?[Y/N] (default value is set to 0.0)");
            if ("N".equals(keyboardScanner.nextLine())) {
                newBookPrice = BigDecimal.ZERO;
                opDone = true;
            } else if("Y".equalsIgnoreCase(keyboardScanner.nextLine())) {
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
    private String getAuthorForNewBook(){
        boolean opDone = false;
        String newAuthor = "";
        while(!opDone){
            System.out.print("book author: ");
            newAuthor =  keyboardScanner.nextLine();
            if(newAuthor.isBlank()){
                System.out.println("Error: can\'t use blank spaces");
            }
            else{
                opDone = true;
            }
        }
        return newAuthor;
        
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
            for(Book book : libraryBookList){
                if(bookTitleToDelete.equals(book.getTitle())){
                    System.out.println("title found\nDeletion completed!!");
                    libraryBookList.remove(index);
                    opDone = true;
                    break;
                }
                else{
                    System.out.println("Error: book not found!!");
                }
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
        int size = libraryBookList.size();
        while (size > 0) {
            id++;
            size--;
        }
        return id;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        for (Book book : libraryBookList) {
            strBuilder.append(book.toString() + "\n");
        }
        return (strBuilder.toString());
    }

}
