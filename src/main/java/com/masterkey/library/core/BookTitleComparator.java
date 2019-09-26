package com.masterkey.library.core;

import java.util.Comparator;

public class BookTitleComparator implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		Book bookO1 = o1;
		Book bookO2 = o2;
		return bookO1.getTitle().compareTo(bookO2.getTitle());
	}

}
