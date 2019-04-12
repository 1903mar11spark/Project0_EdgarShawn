package com.revature.screens;

import java.io.BufferedReader;

import com.revature.beans.Account;
import com.revature.dao.AccountDAOImpl;
import com.revature.util.AppState;

public class FunctionScreen implements Screen 
{

	@Override
	public Screen start(BufferedReader br) 
	{
		
		String customerSelection;
		System.out.println("  (^w^) Welcome " + AppState.getCurrentCustomer().getFirstName() + ", how can we assist you today?");
		
		// Display the customer display 
		
		System.out.println("1) View account balances");
		System.out.println("2) Make a deposit");
		System.out.println("3) Make a withdrawal");
		System.out.println("4) Sign Out");
		
		
		try {
			
			// Get the client's menu selection
			System.out.print("Selection: ");
			customerSelection = br.readLine();
			
			// Navigate to the appropriate screen based on the client's selection
			switch(customerSelection) {
			case "1":
				//Get balance
				AccountDAOImpl accountDAO = new AccountDAOImpl();
				Account acc = accountDAO.getAccountByCustId(AppState.getCurrentCustomer().getId());
				System.out.println("Getting balance for you " + AppState.getCurrentCustomer().getFirstName() + "...");
				System.out.println("Balance is:  $" + acc.getBalance() + " dollars");
				System.out.println("  Returning to Function Screen...   ");
				this.start(br);
			case "2":
				// Make a deposit
				System.out.println("Make a deposit option selected.");
				return new DepositScreen().start(br);
			case "3":
				// Navigate to the MakeAWithDrawalScreen
				System.out.println("Make a withdrawal option selected.");
				//return new MakeAWithdrawalScreen().start(br);
				break;
			case "4":
				System.out.println("Goodbye " + AppState.getCurrentCustomer().getFirstName() + "! signing you out...");
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
			System.out.println("Error");
			AppState.setAppRunning(false);
			return null;
		}
		
		// If the application flow makes it to this point, log out the current client and go back to Home screen
		AppState.setCurrentCustomer(null);
		return new HomeScreen().start(br);
	}

}

