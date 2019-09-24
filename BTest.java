package com.javacourse.inheritanceExample.b;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class BTest {

	@Test
	public void test() {
		B b = new B(2,3,4);
		assertEquals(9, b.sum());
	}

}
