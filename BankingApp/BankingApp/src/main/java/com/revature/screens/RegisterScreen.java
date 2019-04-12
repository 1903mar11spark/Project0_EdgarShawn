package com.revature.screens;

import java.io.BufferedReader;

import com.revature.beans.Customer;
import com.revature.dao.CustomerDAOImpl;
import com.revature.util.AppState;

public class RegisterScreen implements Screen 
{
	public Screen start(BufferedReader br) 
	{
		CustomerDAOImpl customerDAOImp = new CustomerDAOImpl();
		
		// Method-scoped references to hold registration input
		String userName;
		String passWord;
		String firstName;
		String lastName;
		
		try 
		{	
			// Get client registration input
			System.out.println("\n+---------------------------------+\n");
			System.out.println("Sign up for a new account");
			System.out.print("Username: ");
			userName = br.readLine();
			System.out.print("Password: ");
			passWord = br.readLine();
			System.out.print("First Name: ");
			firstName = br.readLine();
			System.out.print("Last Name: ");
			lastName = br.readLine();
			
			// Create a customer object using the input provided
//			Customer newCustomer = new Customer(firstName, lastName, userName, passWord);
			Customer newCustomer = customerDAOImp.createCustomer(firstName, lastName, userName, passWord);
			
			
			// Attempt to register customer and update the currentClient field of AppState to the return value of .add
			AppState.setCurrentCustomer(newCustomer);
			
			// If AppState.currentCustomer is not null, then the registration process 
			//was successful, and navigate to theFunction screen
			if(AppState.getCurrentCustomer() != null) 
			{
				System.out.println("Welcome ! Logging in and navigating to FunctionScreen...");
				return new FunctionScreen().start(br);
			} 
			
			// If AppState.currentCustomer is null, then the registration process failed due to invalid field values
			else 
			{
				System.out.println("[WARN] - Customer not created, invalid field values");
			}
		} 
		
		catch(Exception e) 
		{
			System.out.println("[ERROR] - Error reading input from console");
			AppState.setAppRunning(false);
			return null;
		}
		
		// If the application flow makes it to this point, show the Home screen
		return new HomeScreen().start(br);
	}

}
