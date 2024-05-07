package com.moop.utility;

import java.sql.Connection;
import java.util.Scanner;

import com.moop.dao.ContractsDAO;
import com.moop.service.ContractsService;

public class ContractsUtility {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Connection connection=ContractsDAO.getConnection();
		 
		char goToMainMenu='y';
	     while(goToMainMenu=='y')
	     {
	    	 System.out.println("\n 1: To display milsetone details\n 2: insert Details \n 3: inert to milestone\n 4: Update  milestone staus\n \n  Enter the choice");	 
	   int choice =scanner.nextInt(); 	 
	     
	    switch(choice)
	    {
	    
	    case 1:ContractsService.display(ContractsDAO.readData(connection));
	           break;
	    case 2:
	      System.out.println("How many contracts do you want to add");
	      int size=scanner.nextInt();
	      ContractsDAO.insertData(connection,size);
	      break;
	      
	    case 3:    
		      ContractsDAO.insertMilestone(connection,0);
		      break;
	    case 4:    
		      ContractsDAO.updateMilestone(connection);
		      break;
	     
	    }
	     System.out.println("Do you want to  go to main menu(y/n):");
	      goToMainMenu=scanner.next().charAt(0);
	     }  

	}

}
