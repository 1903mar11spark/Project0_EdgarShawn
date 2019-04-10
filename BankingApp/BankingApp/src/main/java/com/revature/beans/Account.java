package com.revature.beans;

public class Account {

	public Account() {
		super();
		
	}
	public Account(int id, int accountNum, double balance) {
		super();
		this.id = id;
		this.accountNum = accountNum;
		this.balance = balance;
	}

	private int id;
	private int accountNum;
	private double balance;
	
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public int getAccountNum() {return accountNum;}
	public void setAccountNum(int accountNum) {this.accountNum = accountNum;}
	
	public double getBalance() {return balance;}
	public void setBalance(double balance) {this.balance = balance;}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNum=" + accountNum + ", balance=" + balance + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNum;
		long temp;
		temp = Double.doubleToLongBits(balance);
		//trying to make sure if its 0 
		//result = prime * result + ((accountNum == null)? 0 : accountNum.hashCode());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNum != other.accountNum)
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
