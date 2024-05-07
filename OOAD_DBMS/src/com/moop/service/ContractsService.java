package com.moop.service;

import java.util.ArrayList;

import com.moop.dao.ContractsDAO;
import com.moop.entity.Clients;
import com.moop.entity.ContractDocuments;
import com.moop.entity.Contracts;
import com.moop.entity.Employees;
import com.moop.entity.Milestone;

public class ContractsService {

	public static Clients findClient(ArrayList<Clients> clients, int clientId) {
		for (Clients client : clients) {
			if (client.getClientId() == clientId) {
				return client;
			}
		}
		return null;
	}

	public static Employees findEmployee(ArrayList<Employees> employees, int employeeId) {
		for (Employees employee : employees) {
			if (employee.getId() == employeeId) {
				return employee;
			}
		}
		return null;
	}

	public static Contracts findContract(ArrayList<Contracts> contracts, int contractId) {
		for (Contracts contract : contracts) {
			if (contract.getContractId() == contractId) {
				return contract;
			}
		}
		return null;
	}

	public static void display(ArrayList<Contracts> contracts) {
		System.out.println("\nContracts:");
		int count = 0;
		int count1 = 0;
		for (Contracts contract : contracts) {

			if (count == 0) {
				if (contracts.get(0).getContractId() == contracts.get(1).getContractId()) {
					count = 1;
				}
				System.out.println("Contract ID: " + contract.getContractId());
				System.out.println(
						"Client: " + contract.getClient().getFirstName() + " " + contract.getClient().getLastName());
				System.out.println("Created By: " + contract.getCreatedBy().getFirstName() + " "
						+ contract.getCreatedBy().getLastName());
				System.out.println("Updated By: " + contract.getUpdatedBy().getFirstName() + " "
						+ contract.getCreatedBy().getLastName());
				System.out.print("Document Name: ");
				for (ContractDocuments document : contract.getDocuments()) {

					System.out.println(document.getDocumentName());
				}

			}
			if (count1 == 0) {
				System.out.println(
						"\n********************************************Milestone Details*****************************************\n\n");
				System.out.printf("%12s | %12s | %12s | %12s | %12s |\n", "Milestone N0", "Milestone Amount",
						"Milestone Start Date", "Milestone End Date", "Milestone Status");
				count1 = 1;
			}
			for (Milestone milestone : contract.getMilestones()) {
				System.out.printf("\n%12s | %16s | %20s | %18s | %16s |\n", milestone.getMilestoneNo(),
						milestone.getAmount(), milestone.getStartDate(), milestone.getEndDate(), milestone.getStatus());

			}
		}

	}
}
