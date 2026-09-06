package com.packagedeliverytracker.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import com.packagedeliverytracker.model.DeliveryAgent;

public class DeliveryAgentService {

	private ArrayList<DeliveryAgent> agents = new ArrayList<>();

	// CREATE
	public void addAgent(DeliveryAgent agent) {

		agents.add(agent);

		System.out.println("Delivery agent added successfully!");
	}

	// READ
	public void viewAgents() {

		if (agents.isEmpty()) {

			System.out.println("No delivery agents found.");

			return;
		}

		Iterator<DeliveryAgent> itr = agents.iterator();

		while (itr.hasNext()) {

			DeliveryAgent agent = itr.next();

			agent.display();

			System.out.println("----------------------------");
		}
	}

	// SEARCH
	public DeliveryAgent searchAgent(int id) {

		Iterator<DeliveryAgent> itr = agents.iterator();

		while (itr.hasNext()) {

			DeliveryAgent agent = itr.next();

			if (agent.getId() == id) {

				return agent;
			}
		}

		return null;
	}

	// UPDATE
	public void updateAgent(int id, String name, String phone, String vehicle, boolean available) {

		ListIterator<DeliveryAgent> itr = agents.listIterator();

		while (itr.hasNext()) {

			DeliveryAgent agent = itr.next();

			if (agent.getId() == id) {

				DeliveryAgent updatedAgent = new DeliveryAgent(id, name, phone, vehicle, available);

				itr.set(updatedAgent);

				System.out.println("Delivery agent updated successfully!");

				return;
			}
		}

		System.out.println("Delivery agent not found.");
	}

	// DELETE
	public void deleteAgent(int id) {

		Iterator<DeliveryAgent> itr = agents.iterator();

		while (itr.hasNext()) {

			DeliveryAgent agent = itr.next();

			if (agent.getId() == id) {

				itr.remove();

				System.out.println("Delivery agent deleted successfully!");

				return;
			}
		}

		System.out.println("Delivery agent not found.");
	}

	// VIEW AVAILABLE AGENTS
	public void viewAvailableAgents() {

		boolean found = false;

		Iterator<DeliveryAgent> itr = agents.iterator();

		while (itr.hasNext()) {

			DeliveryAgent agent = itr.next();

			if (agent.isAvailable()) {

				agent.display();

				System.out.println("----------------------------");

				found = true;
			}
		}

		if (!found) {

			System.out.println("No available delivery agents.");
		}
	}
}