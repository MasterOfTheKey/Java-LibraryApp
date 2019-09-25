package com.javacourse.geometry;

public class Triangolo extends Figura{
	double base, altezza;

	public Triangolo(double base, double altezza) {
		this.base = base;
		this.altezza = altezza;
	}

	@Override
	public double area() {
		return (base*altezza)/2;
	}

	@Override
	public String descriviti() {
		return "triangolo";
	}
	
}
