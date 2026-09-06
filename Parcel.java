package com.packagedeliverytracker.model;

import com.packagedeliverytracker.interfaces.Trackable;

public class Parcel implements Trackable {

	private String trackingId;
	private String parcelName;
	private double weight;
	private String source;
	private String destination;
	private String status;

	private Customer customer;
	private DeliveryAgent agent;

	public Parcel(String trackingId, String parcelName, double weight, String source, String destination,
			Customer customer) {

		this.trackingId = trackingId;
		this.parcelName = parcelName;
		this.weight = weight;
		this.source = source;
		this.destination = destination;
		this.customer = customer;
		this.status = "Booked";
	}

	public String getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public String getParcleName() {
		return parcelName;
	}

	public void setParcleName(String parcleName) {
		this.parcelName = parcleName;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestnation() {
		return destination;
	}

	public void setDestnation(String destnation) {
		this.destination = destnation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public DeliveryAgent getAgent() {
		return agent;
	}

	public void setAgent(DeliveryAgent agent) {
		this.agent = agent;
	}

	@Override
    public void trackPackage() {

        System.out.println("\n========== PARCEL DETAILS ==========");

        System.out.println("Tracking ID : " + trackingId);
        System.out.println("Parcel Name : " + parcelName);
        System.out.println("Weight      : " + weight + " kg");
        System.out.println("Source      : " + source);
        System.out.println("Destination : " + destination);
        System.out.println("Status      : " + status);
        System.out.println("Customer    : " + customer.getName());

        if (agent != null) {
            System.out.println("Agent       : " + agent.getName());
        } else {
            System.out.println("Agent       : Not Assigned");
        }

        System.out.println("====================================");
    }

	@Override
	public void updateStatus(String status) {
		this.status = status;
		System.out.println("Parcel status updated successfully!");

	}

}
