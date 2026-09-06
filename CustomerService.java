package com.packagedeliverytracker.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import com.packagedeliverytracker.model.Customer;

public class CustomerService {

	private ArrayList<Customer> customers = new ArrayList<>();

	// add customers
	public void addCustomer(Customer customer) {
		customers.add(customer);
		System.out.println("Customer registered successfully!");
	}

	// read
	public void viewCustomers() {
		if (customers.isEmpty()) {
			System.out.println("No customers found.");
			return;
		}

		Iterator<Customer> itr = customers.iterator();
		while (itr.hasNext()) {
			Customer customer = itr.next();
			customer.display();
			System.out.println("----------------------------");
		}
	}

	// search customer
	public Customer searchCustomer(int id) {

		Iterator<Customer> itr = customers.iterator();

		while (itr.hasNext()) {
			Customer customer = itr.next();
			if (customer.getId() == id) {
				return customer;
			}
		}
		return null;
	}

	// update customer

	public void updateCustomer(int id, String name, String phone, String address) {
		ListIterator<Customer> itr = customers.listIterator();

		while (itr.hasNext()) {
			Customer customer = itr.next();
			if (customer.getId() == id) {
				Customer updatescustomer = new Customer(id, name, phone, address);
				itr.set(updatescustomer);
				System.out.println("customer updated successfully!");
				return;
			}
		}
		System.out.println("Customer not found");
	}

	// delete customer

	public void deleteCustomer(int id) {
		Iterator<Customer> itr = customers.iterator();

		while (itr.hasNext()) {
			Customer customer = itr.next();
			if (customer.getId() == id) {
				itr.remove();
				System.out.println("Customer deleted successfully!");
				return;
			}
		}
		System.out.println("Customer not found.");
	}
}