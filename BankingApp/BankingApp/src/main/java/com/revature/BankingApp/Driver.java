package com.revature.BankingApp;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.revature.screens.HomeScreen;
import com.revature.screens.Screen;

public class Driver {
	public static void main( String[] args )
	{
		
		Screen screen = new HomeScreen();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		screen.start(br);
		
		
		
//        AccountDAO acc = new AccountDAOImpl();
//        List<Account> accountList = acc.getAccounts();
//  
//        for(Account a: accountList) 
//        {
//        	System.out.println(a);
//        }
       
  
      
    }
}
