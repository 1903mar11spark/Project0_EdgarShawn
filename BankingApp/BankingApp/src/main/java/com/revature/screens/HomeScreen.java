package com.revature.screens;

import java.io.BufferedReader;

import com.revature.util.AppState;

public class HomeScreen 
{


	public Screen start(BufferedReader br) 
	{
		System.out.println("Current customer: " + AppState.getCurrentCustomer());
		
		// If there is no client currently logged in, display the Home screen for login/registration/exit
		if(AppState.getCurrentCustomer() == null) 
		{
			
			System.out.println("+--        ----------------         --+");
			System.out.println("|    --------            --------     |");
			System.out.println("|------          HELLO!         ------|");
			System.out.println("|---------                  ----------|");
			System.out.println("|              Welcome to             |");
			System.out.println("|        Basic Bank of Commerce       |");
			System.out.println("|------                        -------|");
			System.out.println("|--------                     --------|");
			System.out.println("|    --------            --------     |");
			System.out.println("|--        ----------------         --|");
			System.out.println("|               ------                |");
			System.out.println("+   --   Please select an option: --  +\n");
			
			System.out.println("			A) Login");
			System.out.println("			B) Create Account");
			System.out.println("			C) Exit");
			
			try 
			{
				
				// Get the client's menu selection
				String customerSelection = br.readLine();
				
				switch(customerSelection) 
				{
					case "A":
						// navigates to the Login screen;
						return new LoginScreen().start(br);
					case "B":
						// navigates to the Registration screen
						return new RegisterScreen().start(br);
					case "C":
						// exits the application
						AppState.setAppRunning(false);
						break;
					default:
						// Loop back to the beginning of the Home screen;
						System.out.println("Not a selection");
						this.start(br);
				}
				
			} catch (Exception e) 
			{
				System.out.println("[ERROR] - Error reading input from console");
				AppState.setAppRunning(false);
				return null;
			}
		}
		
		// If there is a client currently logged in, 
		//skip the Home screen and display the customer information from Function
		else 
		{
			return new FunctionScreen().start(br);
		}
		
		// If somehow the application makes it to this point, we will simply display this screen again
				return (Screen) this;
	}
	
}
