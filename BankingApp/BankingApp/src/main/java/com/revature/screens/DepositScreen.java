package com.revature.screens;

import java.io.BufferedReader;
import java.io.IOException;

import com.revature.beans.Account;
import com.revature.dao.AccountDAOImpl;
import com.revature.util.AppState;

public class DepositScreen implements Screen {

	@Override
	public Screen start(BufferedReader br) {
		
		
		
		
		System.out.println("\n");
		System.out.println("Lets deposit some money shall we... \n");
		
		try {
			System.out.println("Enter amount you would like to deposit: ");
			String depositAmount = br.readLine();
			
			if(Double.parseDouble(depositAmount) < 1) {
				System.out.println("Cannot Deposit less than one dollar");
				this.start(br);
			}else if(Double.parseDouble(depositAmount) > 1000) {
				System.out.println("Cannot deposit more than $1,000 dollars, change banks if you dont like it");
				this.start(br);
			}
			
			double amount = Double.parseDouble(depositAmount);
			AccountDAOImpl accountDAO = new AccountDAOImpl();
			Account acc = accountDAO.getAccountByCustId(AppState.getCurrentCustomer().getId());
			acc.setBalance(acc.getBalance() + amount);
			System.out.println("New Balance is:  $" + (acc.getBalance() + amount) + " dollars");
			//AccountDAOImpl newAccount = AccountDAOImpl
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
