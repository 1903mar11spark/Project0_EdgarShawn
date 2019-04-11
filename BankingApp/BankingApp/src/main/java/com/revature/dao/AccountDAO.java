package com.revature.dao;

import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Customer;

public interface AccountDAO {

	public List<Account> getAccounts();
	public Account getAccountByCustId(int id);
	public void createAccount(Account account);
	public void updateAccount(Account account);
	public void deleteAccount(Account account);
	
	
	public Customer add(Customer newCustomer);
	
}
