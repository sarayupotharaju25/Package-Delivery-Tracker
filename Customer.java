package com.packagedeliverytracker.model;

public class Customer extends Person {

	private String address;

	public Customer(int id, String name, String phone, String address) {
		super(id, name, phone);
		this.address = address;
	}

	// getters and setters for address field
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public void display() {
		System.out.println("Customer ID : " + getId());
		System.out.println("Name        : " + getName());
		System.out.println("Phone       : " + getPhone());
		System.out.println("Address     : " + address);
	}
}
