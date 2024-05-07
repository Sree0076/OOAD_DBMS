package com.moop.dao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.moop.entity.Clients;
import com.moop.entity.ContractDocuments;
import com.moop.entity.Contracts;
import com.moop.entity.Employees;
import com.moop.entity.Milestone;
import com.moop.service.ContractsService;

public class ContractsDAO {
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/contracts";
		String userName = "root";
		String password = "root";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static ArrayList<Contracts> readData(Connection connection) {

		ArrayList<Clients> clients = new ArrayList<>();
		ArrayList<Employees> employees = new ArrayList<>();
		ArrayList<Contracts> contractsList = new ArrayList<>();
		PreparedStatement statement = null;
		Scanner scanner=new Scanner(System.in);
		ResultSet rs = null;

		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM clients");
			while (rs.next()) {
				Clients client = new Clients(rs.getInt("client_id"), rs.getString("client_firstname"),
						rs.getString("client_lastname"), rs.getString("client_email"), rs.getString("client_phone"));
				clients.add(client);
			}

			rs = stmt.executeQuery("SELECT * FROM employees");
			while (rs.next()) {
				Employees employee = new Employees(rs.getInt("id"), rs.getString("employee_firstname"),
						rs.getString("employee_lastname"), rs.getString("employee_email"),
						rs.getString("employee_phone"), rs.getDate("employee_hire_date"));
				employees.add(employee);

			}
			String searchType="contracts.contract_id";
			String query = "SELECT * FROM contracts " + "INNER JOIN clients ON clients.client_id = contracts.client_id "
					+ "INNER JOIN employees AS created ON created.id = contracts.created_by "
					+ "INNER JOIN employees AS updated ON updated.id = contracts.updated_by "
					+ "INNER JOIN contract_documents ON contract_documents.contract_id = contracts.contract_id "
					+ "INNER JOIN milestone ON milestone.contract_id = contracts.contract_id  where "+searchType+" =? ";
			statement = connection.prepareStatement(query);
			System.out.println("Enter the contract id ");
			int search = scanner.nextInt();
			statement.setInt(1, search);
			rs = statement.executeQuery();
			while (rs.next()) {

				Clients client = ContractsService.findClient(clients, rs.getInt("client_id"));
				Employees createdBy = ContractsService.findEmployee(employees, rs.getInt("created_by"));
				Employees updatedBy = ContractsService.findEmployee(employees, rs.getInt("updated_by"));

				Contracts contract = new Contracts(rs.getInt("contract_id"), client, rs.getDate("startdate"),
						rs.getDate("enddate"), rs.getDouble("total_amount"), rs.getDouble("balance_amount"),
						rs.getString("status"), rs.getDate("create_date"), rs.getDate("update_date"), createdBy,
						updatedBy, rs.getString("milestone_type"));

				Employees uploadBy = ContractsService.findEmployee(employees,
						rs.getInt("contract_documents.upload_by"));
				Employees documentsUpdatedBy = ContractsService.findEmployee(employees,
						rs.getInt("contract_documents.updated_by"));
				ContractDocuments document = new ContractDocuments(rs.getInt("id"), contract,
						rs.getString("document_name"), rs.getString("document_path"), rs.getDate("upload_date"),
						rs.getDate("update_date"), uploadBy, documentsUpdatedBy);

				Employees milestoneCreatedBy = ContractsService.findEmployee(employees,
						rs.getInt("milestone.created_by"));
				Employees milestoneUpdatedBy = ContractsService.findEmployee(employees,
						rs.getInt("milestone.updated_by"));

				Milestone milestone = new Milestone(rs.getInt("id"), contract, rs.getInt("milestone_no"),
						rs.getDate("startdate"), rs.getDate("enddate"), rs.getDouble("amount"), rs.getString("milestone.status"),
						rs.getDate("create_date"), rs.getDate("update_date"), milestoneCreatedBy, milestoneUpdatedBy);

				contract.getDocuments().add(document);
				contract.getMilestones().add(milestone);

				contractsList.add(contract);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contractsList;

	}
	
	public static void insertData(Connection connection,int size)
	{
		Scanner scanner=new Scanner(System.in);
		
		PreparedStatement statement = null;
		for(int i=0;i<size;i++)
		{
		  try {

   	      String query1 = "INSERT INTO contracts (client_id, startdate, enddate, total_amount,"
			   	      		+ " status,create_date,update_date, created_by, updated_by, milestone_type) "
			   	      		+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
             statement = connection.prepareStatement(query1);
             System.out.println("Enter the client Id :");
             int column7Value=scanner.nextInt();
             System.out.println("Enter the contracts startdate :");
             String column1Value=scanner.next();
             System.out.println("Enter the contracts Enddate :");
             String column2Value=scanner.next();
             System.out.println("Enter the amount of contract :");
             double column3Value=scanner.nextDouble();
             System.out.println("Enter the contracts status :");
             String column4Value=scanner.next();
             System.out.println("Enter the your id :");
             int column5Value=scanner.nextInt();
             System.out.println("Enter the milestone type (weekly,monthly,quaterly,yearly) :");
             String column6Value=scanner.next();

             statement.setInt(1,column7Value);
             statement.setString(2, column1Value);
             statement.setString(3, column2Value);
             statement.setDouble(4, column3Value);
             statement.setString(5, column4Value);
             LocalDate currentLocalDate = LocalDate.now();
             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
             String formattedDate = currentLocalDate.format(formatter);
             statement.setString(6, formattedDate);
             statement.setString(7, formattedDate); 
					statement.setInt(8, column5Value);
					statement.setInt(9, column5Value);
					statement.setString(10, column6Value);;
				statement.executeUpdate();
				System.out.println("Do you want to add documents for the contracts (y/n)");
				char choice =scanner.next().charAt(0);
				scanner.nextLine();
				if (choice=='y')
				{
				insertDocuments(connection,column5Value);
				}
				System.out.println("Do you want to add milestone for the contracts (y/n)");
				char choice1 =scanner.next().charAt(0);
				if (choice1=='y')
				{
				insertMilestone(connection,column5Value);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void insertDocuments(Connection connection,int employeeId)
	{
	Scanner scanner=new Scanner(System.in);
		
		PreparedStatement statement = null;
		  try {

	   	      String query2 = "INSERT INTO contract_documents (contract_id, document_name, document_path, upload_by, updated_by) "
				   	      		+ "VALUES (?,?,?,?,?)";
	             statement = connection.prepareStatement(query2);
	             System.out.println("Enter the contract id :");
	             int column1Value=scanner.nextInt();
	             System.out.println("Enter the contracts document_name :");
	             String column2Value=scanner.next();
	             System.out.println("Enter the contracts ocument_path :");
	             String column3Value=scanner.next();


	             statement.setInt(1,column1Value);
	             statement.setString(2, column2Value);
	             statement.setString(3, column3Value);
	             statement.setInt(4, employeeId);
	             statement.setInt(5, employeeId);

					statement.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


	}
	public static void insertMilestone(Connection connection,int id)
	{
	Scanner scanner=new Scanner(System.in);
	if(id==0)
	{
		System.out.println("Enter your id");
		id=scanner.nextInt();		
	}
		
		PreparedStatement statement = null;
		  try {

	   	      String query3 = "INSERT INTO milestone (contract_id, milestone_no, startdate, enddate, amount, status, created_by, updated_by)"
				   	      		+ "VALUES (?,?,?,?,?,?,?,?)";
	             statement = connection.prepareStatement(query3);
	             System.out.println("Enter the contract id :");
	             int column1Value=scanner.nextInt();
	             System.out.println("Enter the contracts milestone no :");
	             int column2Value=scanner.nextInt();
	             System.out.println("Enter the milestone start date :");
	             String column3Value=scanner.next();
	             System.out.println("Enter the milestone end date :");
	             String column4Value=scanner.next();
	             System.out.println("Enter the amount of contract :");
	             double column5Value=scanner.nextDouble();
	             System.out.println("Enter the status :");
	             String column6Value=scanner.next();


	             statement.setInt(1,column1Value);
	             statement.setInt(2, column2Value);
	             statement.setString(3, column3Value);
	             statement.setString(4, column4Value);
	             statement.setDouble(5, column5Value);
	             statement.setString(6, column6Value);
	             statement.setInt(7, id);
	             statement.setInt(8, id);
					statement.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	
	}
	public static void updateMilestone(Connection connection)
	{
	Scanner scanner=new Scanner(System.in);

		
		PreparedStatement statement = null;
		  try {

	   	      String query3 = "Update milestone set status=? where  contract_id=? and milestone_no=? ";
	             statement = connection.prepareStatement(query3);
	             System.out.println("Enter the contract id :");
	             int column1Value=scanner.nextInt();
	             System.out.println("Enter the contracts milestone no :");
	             int column2Value=scanner.nextInt();
	             System.out.println("Enter the status :");
	             String column6Value=scanner.next();


	             statement.setInt(2,column1Value);
	             statement.setInt(3, column2Value);
	             statement.setString(1, column6Value);

					statement.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


	}
}
