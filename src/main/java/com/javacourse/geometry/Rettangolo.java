package com.javacourse.geometry;

public class Rettangolo extends Figura{
	double base, altezza;
	public Rettangolo(double base,double altezza) {
		this.base=base;
		this.altezza=altezza;
	}
	@Override
	public double area() {
		return base*altezza;
	}

}
