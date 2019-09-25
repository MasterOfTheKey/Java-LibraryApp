package com.javacourse.geometry;

public class Cerchio extends Figura{
	double raggio;
	double PI = Math.PI;
	public Cerchio(double raggio) {
		this.raggio = raggio;
	}
	@Override
	public double area() {
		return (raggio*raggio)*PI;
	}
	@Override
	public String descriviti() {
		return "cerchio";
	}

}
