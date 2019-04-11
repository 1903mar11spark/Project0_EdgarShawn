package com.revature.BankingApp;


import java.util.List;

import com.revature.beans.Account;
import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;

public class Driver {
	public static void main( String[] args )
	{
        AccountDAO acc = new AccountDAOImpl();
        List<Account> accountList = acc.getAccounts();
  
        for(Account a: accountList) 
        {
        	//System.out.println(a);
        }
       
     



        
        
        
        
    }
}
