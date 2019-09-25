package com.javacourse.miscellaneous;

public class equalIsNot {

	public boolean equalIsNot(String str) {
		int countIs = 0;
		int whereIs = -2;
		while((whereIs = str.indexOf(whereIs+2))!=-1)countIs++;
		int countNot = 0;
		int whereNot = -3;
		while((whereNot = str.indexOf(whereNot+2))!=-1)countNot++;
		return(countIs == countNot);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
