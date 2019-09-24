package com.javacourse.inheritanceExample.b;

import static org.junit.Assert.*;

import org.junit.Test;

public class BTest {

	@Test
	public void testB() {
		
	}

	@Test
	public void testSum() {
		B b = new B(1,1,1);
		assertEquals(3,b.sum());
	}

}
