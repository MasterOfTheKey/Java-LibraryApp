package com.javacourse.geometry;

public class Quadrato extends Figura{
	double lato;
	public Quadrato(double lato) {
		this.lato = lato;
		nomeFigura = "quadrato";
	}
	@Override
	public double area() {
		return lato*lato;
	}
}
