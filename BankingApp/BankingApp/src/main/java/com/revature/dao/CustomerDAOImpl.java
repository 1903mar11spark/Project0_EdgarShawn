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
	public Customer createCustomer(String firstName, String lastName, String userName, String passWord ) {
		Customer customer1  = new Customer();
		
		ConnectionUtil.getInstance();
		try(Connection con = ConnectionUtil.getConnection())
		{
			String sql = "INSERT INTO CUSTOMER VALUES(0, ?, ?, ?, ?)";
			String keys[] = new String[1];
			keys[0] = "USER_ID";
			
			PreparedStatement pstmt  = con.prepareStatement(sql);
			
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, userName);
			pstmt.setString(4, passWord);
			
			int rowInserts = pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if(rowInserts != 0) 
			{
				while(rs.next()) 
				{
					customer1.setId(rs.getInt(1));
					customer1.setFirstName(rs.getString("FIRSTNAME"));
					customer1.setLastName(rs.getString("LASTNAME"));
					customer1.setUserName(rs.getString("USERNAME"));
					customer1.setPassWord(rs.getString("PASS_WORD"));
					
				}
				
				//con.commit();
			}
			
		} 
		catch (SQLException e) 
		{	
			e.printStackTrace();
		}
		return customer1;
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
		
		Customer customer = new Customer();
		
		try(Connection con = ConnectionUtil.getConnection())
		{
			String sql = "SELECT * FROM CUSTOMER WHERE USERNAME = ? AND"
					+ " PASS_WORD = ?";
			
			PreparedStatement pstmt  = con.prepareStatement(sql);
			
			//Set value of the first '?' to the value of 'id' 
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			//Result the query and retrieve a ResultSet
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				customer.setId(rs.getInt("USER_ID"));
				customer.setFirstName(rs.getString("FIRSTNAME"));
				customer.setLastName(rs.getString("LASTNAME"));
				customer.setUserName(rs.getString("USERNAME"));
				customer.setPassWord(rs.getString("PASS_WORD"));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		//System.out.println(customer);
		return customer;
	}

	

}
