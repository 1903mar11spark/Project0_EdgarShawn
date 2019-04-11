package com.revature.screens;

import java.io.BufferedReader;

import com.revature.util.AppState;

public class FunctionScreen implements Screen 
{

	@Override
	public Screen start(BufferedReader br) 
	{
		
		String clientSelection;
		
		System.out.println("[LOG] - Rendering " + AppState.getCurrentCustomer().getFirstName() + "'s Dashboard...");
		
		// Display the customer display 
		System.out.println("\n\n+---------------------------------+\n");
		System.out.println("1) View account balances");
		System.out.println("2) Make a deposit");
		System.out.println("3) Make a withdrawal");
		System.out.println("4) Open new account");
		System.out.println("5) Sign Out");
		
		try {
			
			// Get the client's menu selection
			System.out.print("Selection: ");
			clientSelection = br.readLine();
			
			// Navigate to the appropriate screen based on the client's selection
			switch(clientSelection) {
			case "1":
				// Navigate to the ViewAccountBalancesScreen
				System.out.println("[TEST] - View account balances option selected.");
				//return new ViewAccountBalancesScreen().start(br);
			case "2":
				// Navigate to the MakeADepositScreen
				System.out.println("[TEST] - Make a deposit option selected.");
				//return new MakeADepositScreen().start(br);
			case "3":
				// Navigate to the MakeAWithDrawalScreen
				System.out.println("[TEST] - Make a withdrawal option selected.");
				//return new MakeAWithdrawalScreen().start(br);
			case "4":
				// Navigate to the OpenNewAccountScreen
				System.out.println("[TEST] - Open new account option selected.");
				//return new OpenNewAccountScreen().start(br);
			case "5":
				System.out.println("[LOG] - " + AppState.getCurrentCustomer().getUserName() + " signing out...");
				//setting customer back to null to "log them out"
				AppState.setCurrentCustomer(null);
				return new HomeScreen().start(br);
			default:
				System.out.println("Invalid Selection!");
				this.start(br);
			}
			
		} catch(Exception e) 
		{
			// If any exceptions are thrown restart the application
			System.out.println("[ERROR] - Error reading input from console");
			AppState.setAppRunning(false);
			return null;
		}
		
		// If the application flow makes it to this point, log out the current client and go back to Home screen
		AppState.setCurrentCustomer(null);
		return new HomeScreen().start(br);
	}

}

