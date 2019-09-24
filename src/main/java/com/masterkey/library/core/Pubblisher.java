package com.masterkey.library.core;

public class Pubblisher {
	long id;
	String name;
	public Pubblisher(long id, String name) {
		this.id = id;
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Pubblisher [id=" + id + ", name=" + name + "]";
	}
	
	
}
