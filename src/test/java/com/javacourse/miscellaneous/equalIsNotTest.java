package com.javacourse.miscellaneous;

import static org.junit.Assert.*;

import org.junit.Test;

public class equalIsNotTest {

	@Test
	public void test() {
		equalIsNot test = new equalIsNot();
		assertEquals(true,test.equalIsNot("isisisnotnotnot"));
	}

}
