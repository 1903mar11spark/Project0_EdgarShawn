package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.util.ConnectionUtil;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerByCredentials(String username, String password) {
		Account account = null;
		
		try(Connection con = ConnectionUtil.getConnection())
		{
			String sql = "SELECT ACCOUNT_ID, ACCOUNT_NUMBER, BALANCE FROM ACCOUNTS WHERE USERNAME = ? AND"
					+ " PASS_word = ?";
			
			PreparedStatement pstmt  = con.prepareStatement(sql);
			
			//Set value of the first '?' to the value of 'id' 
			pstmt.setString(1, username);
			pstmt.setString(2,password);
			
			//Result the query and retrieve a ResultSet
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int accountId = rs.getInt("ACCOUNT_ID");
				int accountNum = rs.getInt("ACCOUNT_NUMBER");
				double balance = rs.getDouble("BALANCE");
				account = new Account(accountId, accountNum, balance);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		
		return account;
		return null;
	}

	

}
