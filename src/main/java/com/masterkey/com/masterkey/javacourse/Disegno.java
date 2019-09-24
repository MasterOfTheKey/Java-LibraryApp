package com.masterkey.com.masterkey.javacourse;

import com.javacourse.geometry.*;

public class Disegno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Figura figure[] = new Figura[] {new Rettangolo(5,50),new Triangolo(6,6),new Quadrato(4),new Cerchio(3)};
		for(Figura figura:figure) {
			System.out.println(figura.toString());
		}
	}

}
