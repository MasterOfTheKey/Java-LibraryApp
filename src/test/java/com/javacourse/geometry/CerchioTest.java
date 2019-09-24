package com.javacourse.geometry;

import static org.junit.Assert.*;

import org.junit.Test;

public class CerchioTest {
	Figura cerchio = new Cerchio(3);
	@Test
	public void test() {
		assertEquals(28.27, cerchio.area(), 0.01);
	}

}
