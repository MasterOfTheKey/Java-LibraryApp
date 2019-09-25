package com.javacourse.geometry;

import java.util.ArrayList;

public class Disegno {
	ArrayList<Figura> foglio;
	
	public Disegno() {
		foglio = new ArrayList<Figura>();
	}
	
	public void addFigura(Figura figura) {
		foglio.add(figura);
	}
	
	public double totalArea() {
		double somma = 0;
		for(Figura f : foglio) {
			if(f instanceof Figura) {
				somma+=f.area();
			}
		}
		return somma;
	}
}
