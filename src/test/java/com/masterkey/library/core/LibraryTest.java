/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masterkey.library.core;

import java.math.BigDecimal;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author francesco
 */
public class LibraryTest {
    
    
    
    public LibraryTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        long id = 102255;
        String title = "Mauro va a caccia";
        BigDecimal price = null;
        Author[] author = null;
        Pubblisher pubblisher = null;
        Library instance = new Library();
        instance.addBook(id, title, price, author, pubblisher);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of addBook method, of class Library.
     */
    @Test
    public void testAddBook() {
        System.out.println("addBook");
        long id = 0L;
        String title = "";
        BigDecimal price = null;
        Author[] author = null;
        Pubblisher pubblisher = null;
        Library instance = new Library();
        instance.addBook(id, title, price, author, pubblisher);
        assertEquals(1,instance.archive.size());
    }

    /**
     * Test of deleteBookByTitle method, of class Library.
     */
    @Test
    public void testDeleteBookByTitle() {
        System.out.println("deleteBookByTitle");
        String title = "Mauro va a caccia";
        Library instance = new Library();
        instance.deleteBookByTitle(title);
        assertEquals(0,instance.archive.size());
    }

    /**
     * Test of deleteBookById method, of class Library.
     */
    @Test
    public void testDeleteBookById() {
        System.out.println("deleteBookById");
        Long id = (long) 102255;
        Library instance = new Library();
        instance.deleteBookById(id);
        assertEquals(0,instance.archive.size());
    }

    /**
     * Test of printArchive method, of class Library.
     */
    @Test
    public void testPrintArchive() {
        System.out.println("printArchive");
        Library instance = new Library();
        instance.printArchive();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
