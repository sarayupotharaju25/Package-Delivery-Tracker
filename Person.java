package com.packagedeliverytracker.model;

public abstract class Person {

	//abstract class
	
	//created person because we never create an generic person\
	//person p= new person does not make sense
	
	//we create customers and delivery agents
	
	private int id;
	private String name;
	private String phone;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Person(int id, String name, String phone) {
		this.id=id;
		this.name=name;
		this.phone=phone;
	}
	
	public abstract void display();
}
