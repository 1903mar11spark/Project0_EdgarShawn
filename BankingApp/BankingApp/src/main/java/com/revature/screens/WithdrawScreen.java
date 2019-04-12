package com.revature.screens;

import java.io.BufferedReader;
import java.io.IOException;

import com.revature.beans.Account;
import com.revature.dao.AccountDAOImpl;
import com.revature.util.AppState;

public class WithdrawScreen implements Screen{

	public Screen start(BufferedReader br){
		
		AccountDAOImpl accountDAO = new AccountDAOImpl();
		Account acc = accountDAO.getAccountByCustId(AppState.getCurrentCustomer().getId());
		
		System.out.println("\n");
		System.out.println("Lets withdraw some money shall we... \n");
		
		try {
			System.out.println("Enter amount you would like to withdraw: ");
			String withdrawAmount = br.readLine();
			
			if(Double.parseDouble(withdrawAmount) < 1) 
			{
				System.out.println("\n");
				System.out.println("    You can't attempt to withdraw NO MONEY....duh   (>_>)   ");
				System.out.println("    Returning to FunctionScreen..");
				System.out.println("\n");
				return new FunctionScreen().start(br);
			}
			else if
			
			(Double.parseDouble(withdrawAmount) > acc.getBalance()) 
			{
				System.out.println("\n");
				System.out.println("    Cannot withdraw more than current balance, change banks if you dont like it");
				System.out.println("    Returning to FunctionScreen..");
				System.out.println("\n");
				return new FunctionScreen().start(br);
			}
			
			double amount = Double.parseDouble(withdrawAmount);
			//AccountDAOImpl accountDAO = new AccountDAOImpl();
			//Account acc = accountDAO.getAccountByCustId(AppState.getCurrentCustomer().getId());
			acc.setBalance(acc.getBalance() - amount);
			System.out.println("New Balance is: " + (double)acc.getBalance() + " dollars");
			accountDAO.updateAccount(acc);
			System.out.println("\n");
			System.out.println("    Withdraw executed!");
			System.out.println("    Returning to FunctionScreen..");
			System.out.println("\n");
			return new FunctionScreen().start(br);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
