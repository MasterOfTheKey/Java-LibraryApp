package com.javacourse.inheritanceExample.b.B;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BTest {

	@Before
	public void before() {
		
	}
	@Test
	public void testB() {
		fail("Not yet implemented");
	}

	@Test
	public void testSum() {
		B b = new B(2,2,2);
		assertEquals(6,b.sum());
	}

}
