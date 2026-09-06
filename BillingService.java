package com.packagedeliverytracker.service;

import com.packagedeliverytracker.model.Bill;

public class BillingService {
	
	public void generateBill(double weight) {
		Bill bill=new Bill(weight);
		bill.calculateBill();
		bill.printBill();
	}
}
