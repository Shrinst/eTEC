package com.e_tec.e_tecserverI.model;

import java.util.ArrayList;

public class Client {

	private String name;
	private String photo;
	private ArrayList<Product> cart; 
	// https://stackoverflow.com/questions/39004951/parsing-json-array-inside-jsonobject-in-android	
	private Client next;
	
	
	public Client() {

	}

	public Client(String name, String photo) {
		this.name = name;
		this.photo = photo;
		this.cart = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public ArrayList<Product> getCart() {
		return cart;
	}

	public void setCart(ArrayList<Product> cart) {
		this.cart = cart;
	}

	public Client getNext() {
		return next;
	}

	public void setNext(Client next) {
		this.next = next;
	}

}
