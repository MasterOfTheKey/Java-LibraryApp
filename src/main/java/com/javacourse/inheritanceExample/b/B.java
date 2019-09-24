package com.javacourse.inheritanceExample.b;

import com.javacourse.inheritanceExample.a.A;

public class B extends A{
	int c;
	
	public B(int a, int b, int c) {
		super(a, b);
		this.c=c;
		// TODO Auto-generated constructor stub
	}
	public int sum() {
		return a+b+c;
	}
}
