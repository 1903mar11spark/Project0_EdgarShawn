package com.revature.dao;

import java.util.List;

import com.revature.beans.Customer;

public interface CustomerDAO 
{
	

	public List<Customer> getCustomers();
	public Customer getCustomerById(int id);
	public void createCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
	
	
	
}
