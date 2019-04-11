package com.revature.BankingApp;

import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;

public class Driver {
	private static Scanner scanner = new Scanner(System.in);
	
	
    public static void main( String[] args ){
    	
    	//Scanner scanner = new Scanner(System.in);
    	//String input = scanner.next();
    	
        AccountDAO acc = new AccountDAOImpl();
        List<Account> accountList = acc.getAccounts();
        //System.out.println(acc.getAccountByCustId(42));
       // System.out.println(acc.createAccount(account));
       // System.out.println(acc.createAccount(null););
        for(Account a: accountList) {
        	//System.out.println(a);
        	}
       
     



        
        
        
        
    }
}
