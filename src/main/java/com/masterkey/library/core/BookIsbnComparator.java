package com.masterkey.library.core;

import java.util.Comparator;

public class BookIsbnComparator implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		Book bookO1 = o1;
		Book bookO2 = o2;
		return bookO1.getIsbn().compareTo(bookO2.getIsbn());
	}

}
