package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.util.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO{

	public List<Account> getAccounts() {
		List<Account> acc = new ArrayList<Account>();
		try(Connection con = ConnectionUtil.getConnection()){
			
			String sql = "SELECT ACCOUNT_ID, ACCOUNT_NUMBER, USER_ID, BALANCE"
					+ " FROM ACCOUNTS";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("ACCOUNT_ID");
				int accountNum = rs.getInt("ACCOUNT_NUMBER");
				double balance = rs.getDouble("BALANCE");
				acc.add(new Account(id, accountNum, balance));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return acc;
	}

	public Account getAccountByCustId(int id) 
	{
		Account account = new Account();
		
		try(Connection con = ConnectionUtil.getConnection())
		{
			String sql = "SELECT ACCOUNT_ID, ACCOUNT_NUMBER, BALANCE FROM ACCOUNTS WHERE USER_ID = 41";
			
			PreparedStatement pstmt  = con.prepareStatement(sql);
			
			//Set value of the first '?' to the value of 'id' 
			//pstmt.setInt(1, id);
			
			//Result the query and retrieve a ResultSet
			//System.out.println(sql);
			
			ResultSet rs = pstmt.executeQuery(sql);
			
			while (rs.next()) {
				int uid = rs.getInt("ACCOUNT_ID");
				int accountNum = rs.getInt("ACCOUNT_NUMBER");
				double balance = rs.getDouble("BALANCE");
				account = new Account(id, accountNum, balance);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		
		return account;
	}
	

	public void createAccount(Account account) 
	{
		
		
	}

	public void updateAccount(Account account) 
	{

		
	}

	public void deleteAccount(Account account) 
	{

		
	}
	
}
