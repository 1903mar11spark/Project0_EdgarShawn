package com.revature.screens;

import java.io.BufferedReader;
import java.io.IOException;

import com.revature.Exceptions.CustomerNotFoundException;
import com.revature.beans.Customer;
import com.revature.dao.CustomerDAOImpl;
import com.revature.util.AppState;


public class LoginScreen implements Screen {
	
	private CustomerDAOImpl customerDAO = new CustomerDAOImpl();
	
	String userName = "";
	String passWord = "";
	
	public Screen start(BufferedReader br) 
	{
		try {
			
			
		System.out.println("Please enter your Username and Password:");
		System.out.println("Provide Username: ");
		userName = br.readLine();
		System.out.println("Enter Password");
		passWord = br.readLine();
		
		
		Customer loggedCustomer = customerDAO.getCustomerByCredentials(userName, passWord);

		// If loggedCustomer is not null, then the login attempt was successful and 
		//we should navigate the client to their dashboard
		if(loggedCustomer != null) {
			
			System.out.println("Loading Function Screen...");
			
			// Change the currentCustomer of AppState to the Customer object 
			//that is returned from the login process
			AppState.setCurrentCustomer(loggedCustomer);
			
			// Navigate to the Function screen
			return new FunctionScreen().start(br);	
		}
		
		//If loggedCustomer is null, the login attempt was unsuccessful 
		//then tell the customer, and then throw a
		//CustomerNotFoundException for logging purposes.
		else 
		{
			// Ensure that the current of AppState is null
			AppState.setCurrentCustomer(null);
			
			// throw a ClientNotFoundException for logging purposes
			throw new CustomerNotFoundException("Invalid credentials provided!");
		}
			
			
		} 
		catch (IOException e) 
		{
			// If any exceptions are thrown...
			System.out.println("Error reading input from console");
			return null;
		} 
		catch (CustomerNotFoundException e) 
		{
			System.out.println("Login attempt unsuccessful, invalid credentials");
		}
		
		System.out.println("[LOG] - Navigating back to home screen...");
		return new LoginScreen().start(br);
	}

}
