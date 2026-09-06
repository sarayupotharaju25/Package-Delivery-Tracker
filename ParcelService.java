package com.packagedeliverytracker.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import com.packagedeliverytracker.model.Customer;
import com.packagedeliverytracker.model.DeliveryAgent;
import com.packagedeliverytracker.model.Parcel;

public class ParcelService {

	private ArrayList<Parcel> parcels = new ArrayList<>();

	private int trackingNumber = 1001;

	// CREATE / BOOK PARCEL

	public void bookParcel(Customer customer, String parcelName, double weight, String source, String destination) {

		String trackingId = "PKG" + trackingNumber++;

		Parcel parcel = new Parcel(trackingId, parcelName, weight, source, destination, customer);

		parcels.add(parcel);

		System.out.println("\nParcel booked successfully!");

		System.out.println("Tracking ID : " + trackingId);
	}

	// READ / VIEW PARCELS

	public void viewParcels() {

		if (parcels.isEmpty()) {
			System.out.println("No parcels available.");
			return;
		}

		Iterator<Parcel> itr = parcels.iterator();
		while (itr.hasNext()) {
			Parcel parcel = itr.next();
			parcel.trackPackage();
			System.out.println("----------------------------");
		}
	}

	// SEARCH PARCEL

	public Parcel searchParcel(String trackingId) {

		Iterator<Parcel> itr = parcels.iterator();

		while (itr.hasNext()) {

			Parcel parcel = itr.next();

			if (parcel.getTrackingId().equalsIgnoreCase(trackingId)) {

				return parcel;
			}
		}

		return null;
	}

	// UPDATE PARCEL

	public void updateParcel(String trackingId, String parcelName, double weight, String source, String destination) {

		ListIterator<Parcel> itr = parcels.listIterator();

		while (itr.hasNext()) {

			Parcel parcel = itr.next();

			if (parcel.getTrackingId().equalsIgnoreCase(trackingId)) {

				Parcel updatedParcel = new Parcel(trackingId, parcelName, weight, source, destination,
						parcel.getCustomer());

				// Preserve assigned agent
				updatedParcel.setAgent(parcel.getAgent());

				// Preserve current status
				updatedParcel.setStatus(parcel.getStatus());

				itr.set(updatedParcel);

				System.out.println("Parcel updated successfully!");

				return;
			}
		}

		System.out.println("Parcel not found.");
	}

	// DELETE PARCEL

	public void deleteParcel(String trackingId) {

		Iterator<Parcel> itr = parcels.iterator();

		while (itr.hasNext()) {
			Parcel parcel = itr.next();
			if (parcel.getTrackingId().equalsIgnoreCase(trackingId)) {
				itr.remove();
				System.out.println("Parcel deleted successfully!");
				return;
			}
		}
		System.out.println("Parcel not found.");
	}

	// ASSIGN AGENT

	public void assignAgent(String trackingId, DeliveryAgent agent) {

		Parcel parcel = searchParcel(trackingId);

		if (parcel != null) {

			parcel.setAgent(agent);

			System.out.println("Delivery agent assigned successfully!");

		} else {

			System.out.println("Parcel not found.");
		}
	}

	// UPDATE STATUS

	public void updateStatus(String trackingId, String status) {

		Parcel parcel = searchParcel(trackingId);

		if (parcel != null) {

			parcel.updateStatus(status);

		} else {

			System.out.println("Parcel not found.");
		}
	}
}