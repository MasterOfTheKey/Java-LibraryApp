package com.javacourse.geometry;

import java.text.DecimalFormat;

public abstract class Figura {																							 String nomeFigura;
	protected static DecimalFormat df = new DecimalFormat(".##");
	
	public abstract double area();
	
	@override
	public String toString() {
		return "l'area della figura "+descriviti()+" e\':"+df.format(area());
	}
	
	public String descriviti() {
		return this.getClass().getSimpleName();
	}
}
