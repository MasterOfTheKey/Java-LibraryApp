package com.javacourse.geometry;

import java.text.DecimalFormat;

public abstract class Figura implements Superficie,Descrivibile{																							 String nomeFigura;
	protected static DecimalFormat df = new DecimalFormat(".##");
	
	@Override
	public String toString() {
		return "l'area della figura "+descriviti()+" e\':"+df.format(area());
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null)return false;
		if(o instanceof Figura) {
			return (this.area() == ((Figura)o).area());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Double.valueOf(this.area()).hashCode();
	}
}
