/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masterkey.library.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author francesco
 */
public class BookTest {
    static Book instance;
    static ArrayList<Author> authors;
    public BookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        authors = new ArrayList<Author>();
        authors.add(new Author(11,"mauro","angioni"));
        instance = new Book(00002,"mauro",new BigDecimal("0.00"),authors,new Pubblisher(555,"lolli"));
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getId method, of class Book.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        long expResult = 2;
        long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Book.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        long id = 0L;
        instance.setId(id);
        assertEquals(0,instance.getId());
    }

    /**
     * Test of getTitle method, of class Book.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        String expResult = "mauro";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTitle method, of class Book.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        instance.setTitle(title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Book.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        BigDecimal expResult = null;
        //assertEquals(expResult, );
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class Book.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        BigDecimal price = null;
        instance.setPrice(price);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAuthor method, of class Book.
     */
    @Test
    public void testGetAuthor() {
        System.out.println("getAuthor");
        ArrayList<Author> expResult = null;
        ArrayList<Author> result = instance.getAuthor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAuthors method, of class Book.
     */
    @Test
    public void testSetAuthors() {
        System.out.println("setAuthors");
        Author author = new Author(3344,"franco","lanciano");
        ArrayList<Author> authors = new ArrayList<Author>();
        authors.add(author);
        instance.setAuthors(authors);
        assertEquals(1,instance.getAuthor().size());
    }

    /**
     * Test of addAuthor method, of class Book.
     */
    @Test
    public void testAddAuthor() {
        System.out.println("addAuthor");
        Author author = new Author(3344,"franco","lanciano");
        instance.addAuthor(author);
        assertEquals(2,instance.getAuthor().size());
    }

    /**
     * Test of addCategory method, of class Book.
     */
    @Test
    public void testAddCategory() {
        System.out.println("addCategory");
        int category = 1;
        instance.addCategory(category);
        assertEquals("adventure ",instance.getCategories());
    }

    /**
     * Test of getCategories method, of class Book.
     */
    @Test
    public void testGetCategories() {
        System.out.println("getCategories");
        String expResult = "";
        String result = instance.getCategories();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isWrittenBy method, of class Book.
     */
    @Test
    public void testIsWrittenBy() {
        System.out.println("isWrittenBy");
        Author author = new Author(11,"mauro","angioni");
        boolean expResult = true;
        boolean result = instance.isWrittenBy(author);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Book.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
