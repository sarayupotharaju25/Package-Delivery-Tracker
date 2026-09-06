package com.packagedeliverytracker.model;


public class DeliveryAgent extends Person {
	
	private String vehicle;
	private boolean available;
	public DeliveryAgent(int id, String name, String phone, String vehicle, boolean available) {
		super(id, name, phone);
		this.vehicle=vehicle;
		this.available=available;
		
	}

	public String getVehicle() {
		return vehicle;
	}
	
	public void setVehicle(String vehicle) {
		this.vehicle=vehicle;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public void setAvailable(boolean available) {
		this.available=available;
	}
	
	@Override
	public void display() {
		System.out.println("Agent ID    : " + getId());
        System.out.println("Name        : " + getName());
        System.out.println("Phone       : " + getPhone());
        System.out.println("Vehicle     : " + vehicle);
        System.out.println("Available   : " + available);
	}
}
