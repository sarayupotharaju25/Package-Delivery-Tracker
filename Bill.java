package com.packagedeliverytracker.model;

public class Bill {

	private double weight;
	private double total;

	public Bill(double weight) {
		this.weight = weight;
	}

	public void calculateBill() {
		if (weight <= 1) {
			total = 40;
		} else if (weight <= 5) {
			total = 80;
		} else if (weight <= 10) {
			total = 100;
		}

		else {
			total = 200;
		}

	}

	public void printBill() {
		System.out.println("Weight         : " + weight + " kg");
		System.out.println("Total Bill     : "+ total);
	}

}
