package com.packagedeliverytracker.main;

import java.util.Scanner;

import com.packagedeliverytracker.model.Customer;
import com.packagedeliverytracker.model.DeliveryAgent;
import com.packagedeliverytracker.model.Parcel;
import com.packagedeliverytracker.service.BillingService;
import com.packagedeliverytracker.service.CustomerService;
import com.packagedeliverytracker.service.DeliveryAgentService;
import com.packagedeliverytracker.service.ParcelService;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		CustomerService customerService = new CustomerService();

		DeliveryAgentService agentService = new DeliveryAgentService();

		ParcelService parcelService = new ParcelService();

		BillingService billingService = new BillingService();

		int choice;

		do {

			System.out.println("==========================================");
			System.out.println("       PACKAGE DELIVERY TRACKER");
			System.out.println("==========================================");

			System.out.println("1.  Add Customer");
			System.out.println("2.  View Customers");
			System.out.println("3.  Search Customer");
			System.out.println("4.  Update Customer");
			System.out.println("5.  Delete Customer");

			System.out.println("\n6.  Add Delivery Agent");
			System.out.println("7.  View Delivery Agents");
			System.out.println("8.  Search Delivery Agent");
			System.out.println("9.  Update Delivery Agent");
			System.out.println("10. Delete Delivery Agent");
			System.out.println("11. View Available Agents");

			System.out.println("\n12. Book Parcel");
			System.out.println("13. View Parcels");
			System.out.println("14. Search Parcel");
			System.out.println("15. Update Parcel");
			System.out.println("16. Delete Parcel");
			System.out.println("17. Assign Delivery Agent");
			System.out.println("18. Track Parcel");
			System.out.println("19. Update Parcel Status");

			System.out.println("20. Generate Bill");

			System.out.println("21. Exit");

			System.out.print("Enter your choice: ");

			choice = sc.nextInt();

			switch (choice) {

			// =====================================
			// CUSTOMER
			// =====================================

			case 1:

				System.out.print("Customer ID: ");
				int customerId = sc.nextInt();

				sc.nextLine();

				System.out.print("Name: ");
				String customerName = sc.nextLine();

				System.out.print("Phone: ");
				String customerPhone = sc.nextLine();

				System.out.print("Address: ");
				String address = sc.nextLine();

				Customer customer = new Customer(customerId, customerName, customerPhone, address);

				customerService.addCustomer(customer);

				break;

			case 2:

				customerService.viewCustomers();

				break;

			case 3:

				System.out.print("Enter Customer ID: ");

				int searchCustomerId = sc.nextInt();

				Customer foundCustomer = customerService.searchCustomer(searchCustomerId);

				if (foundCustomer != null) {

					foundCustomer.display();

				} else {

					System.out.println("Customer not found.");
				}

				break;

			case 4:

				System.out.print("Enter Customer ID to update: ");

				int updateCustomerId = sc.nextInt();

				sc.nextLine();

				System.out.print("New Name: ");
				String newCustomerName = sc.nextLine();

				System.out.print("New Phone: ");
				String newCustomerPhone = sc.nextLine();

				System.out.print("New Address: ");
				String newAddress = sc.nextLine();

				customerService.updateCustomer(updateCustomerId, newCustomerName, newCustomerPhone, newAddress);

				break;

			case 5:

				System.out.print("Enter Customer ID to delete: ");

				int deleteCustomerId = sc.nextInt();

				customerService.deleteCustomer(deleteCustomerId);

				break;

			// =====================================
			// DELIVERY AGENT
			// =====================================

			case 6:

				System.out.print("Agent ID: ");
				int agentId = sc.nextInt();

				sc.nextLine();

				System.out.print("Name: ");
				String agentName = sc.nextLine();

				System.out.print("Phone: ");
				String agentPhone = sc.nextLine();

				System.out.print("Vehicle: ");
				String vehicle = sc.nextLine();

				DeliveryAgent agent = new DeliveryAgent(agentId, agentName, agentPhone, vehicle, true);

				agentService.addAgent(agent);

				break;

			case 7:

				agentService.viewAgents();

				break;

			case 8:

				System.out.print("Enter Agent ID: ");

				int searchAgentId = sc.nextInt();

				DeliveryAgent foundAgent = agentService.searchAgent(searchAgentId);

				if (foundAgent != null) {

					foundAgent.display();

				} else {

					System.out.println("Delivery agent not found.");
				}

				break;

			case 9:

				System.out.print("Enter Agent ID to update: ");

				int updateAgentId = sc.nextInt();

				sc.nextLine();

				System.out.print("New Name: ");
				String newAgentName = sc.nextLine();

				System.out.print("New Phone: ");
				String newAgentPhone = sc.nextLine();

				System.out.print("New Vehicle: ");
				String newVehicle = sc.nextLine();

				System.out.print("Is Agent Available? (true/false): ");

				boolean available = sc.nextBoolean();

				agentService.updateAgent(updateAgentId, newAgentName, newAgentPhone, newVehicle, available);

				break;

			case 10:

				System.out.print("Enter Agent ID to delete: ");

				int deleteAgentId = sc.nextInt();

				agentService.deleteAgent(deleteAgentId);

				break;

			case 11:

				agentService.viewAvailableAgents();

				break;

			// =====================================
			// PARCEL
			// =====================================

			case 12:

				System.out.print("Enter Customer ID: ");

				int parcelCustomerId = sc.nextInt();

				sc.nextLine();

				Customer parcelCustomer = customerService.searchCustomer(parcelCustomerId);

				if (parcelCustomer == null) {

					System.out.println("Customer not found.");

					break;
				}

				System.out.print("Parcel Name: ");

				String parcelName = sc.nextLine();

				System.out.print("Weight (kg): ");

				double weight = sc.nextDouble();

				sc.nextLine();

				System.out.print("Source: ");

				String source = sc.nextLine();

				System.out.print("Destination: ");

				String destination = sc.nextLine();

				parcelService.bookParcel(parcelCustomer, parcelName, weight, source, destination);

				break;

			case 13:

				parcelService.viewParcels();

				break;

			case 14:

				sc.nextLine();

				System.out.print("Enter Tracking ID: ");

				String searchTrackingId = sc.nextLine();

				Parcel foundParcel = parcelService.searchParcel(searchTrackingId);

				if (foundParcel != null) {

					foundParcel.trackPackage();

				} else {

					System.out.println("Parcel not found.");
				}

				break;

			case 15:

				sc.nextLine();

				System.out.print("Enter Tracking ID to update: ");

				String updateTrackingId = sc.nextLine();

				System.out.print("New Parcel Name: ");

				String newParcelName = sc.nextLine();

				System.out.print("New Weight: ");

				double newWeight = sc.nextDouble();

				sc.nextLine();

				System.out.print("New Source: ");

				String newSource = sc.nextLine();

				System.out.print("New Destination: ");

				String newDestination = sc.nextLine();

				parcelService.updateParcel(updateTrackingId, newParcelName, newWeight, newSource, newDestination);

				break;

			case 16:

				sc.nextLine();

				System.out.print("Enter Tracking ID to delete: ");

				String deleteTrackingId = sc.nextLine();

				parcelService.deleteParcel(deleteTrackingId);

				break;

			case 17:

				sc.nextLine();

				System.out.print("Enter Tracking ID: ");

				String assignTrackingId = sc.nextLine();

				System.out.print("Enter Agent ID: ");

				int assignAgentId = sc.nextInt();

				DeliveryAgent deliveryAgent = agentService.searchAgent(assignAgentId);

				if (deliveryAgent != null) {

					parcelService.assignAgent(assignTrackingId, deliveryAgent);

				} else {

					System.out.println("Delivery agent not found.");
				}

				break;

			case 18:

				sc.nextLine();

				System.out.print("Enter Tracking ID: ");

				String trackId = sc.nextLine();

				Parcel parcel = parcelService.searchParcel(trackId);

				if (parcel != null) {

					parcel.trackPackage();

				} else {

					System.out.println("Parcel not found.");
				}

				break;

			case 19:

				sc.nextLine();

				System.out.print("Enter Tracking ID: ");

				String statusTrackingId = sc.nextLine();

				System.out.println("\n1. BOOKED");

				System.out.println("2. PICKED_UP");

				System.out.println("3. IN_TRANSIT");

				System.out.println("4. OUT_FOR_DELIVERY");

				System.out.println("5. DELIVERED");

				System.out.print("Enter Status: ");

				String status = sc.nextLine();

				parcelService.updateStatus(statusTrackingId, status);

				break;

			// =====================================
			// BILL
			// =====================================

			case 20:

				System.out.print("Enter Parcel Weight: ");

				double billWeight = sc.nextDouble();

				billingService.generateBill(billWeight);

				break;

			// =====================================
			// EXIT
			// =====================================

			case 21:

				System.out.println("\nThank you for using " + "Package Delivery Tracker!");

				break;

			default:

				System.out.println("Invalid choice. Please try again.");
			}

		} while (choice != 21);

		sc.close();
	}
}
