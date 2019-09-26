package com.javacourse.collection;
import java.util.Collection;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
public class CollectionExamples {
	public Collection<String> createCollection() {
		Collection<String> c = new LinkedList<>();
		c.add("primo");
		c.add("secondo");
		c.add("terzo");
		return c;
	}
	public void usingCollection(Collection<String> c) {
		for (String string : c) {
			System.out.println(string);
		}
		c.remove("secondo");
		System.out.println(c);
	}
	public void usingCollectionWithIterator(Collection<String> c) {
		Iterator name = c.iterator();
		while(name.hasNext()) {
			System.out.println(name.next());
		}
	}
	public void removeElementFromCollection(Collection<String> c) {
		Iterator<String> it = c.iterator();
		while (it.hasNext()) {
			if(it.next().equalsIgnoreCase("primo")) it.remove();
		}
		System.out.println(c);
	}
	public void convertToSpecificArray(Collection<String> c) {
		Object[] array = c.toArray(new String[0]);
		System.out.println(Arrays.toString(array));
	}
	public static void main(String args[]) {
		CollectionExamples collectionExample = new CollectionExamples();
		Collection<String> col = collectionExample.createCollection();
		collectionExample.convertToSpecificArray(col);
	}
}
