package com.revature.dao;

import java.util.List;

import com.revature.beans.Customer;

public interface CustomerDAO 
{
	

	public List<Customer> getCustomers();
	public Customer getCustomerById(int id);
	public Customer createCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
	public List<Customer> getAll();
	public Customer getCustomerByUsername(String username);
	public Customer getCustomerByCredentials(String username, String password);

}
