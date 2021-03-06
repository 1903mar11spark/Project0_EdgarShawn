package com.revature.beans;

public class Customer 
{
	
	    
	    public Customer(String firstName, String lastName, String userName, String passWord) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
	}

		public Customer(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}

		public Customer() 
	    {
			////stuff
		}

		public Customer(int id, String firstName, String lastName, String userName, String passWord) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
	}
		
		

		private int id;
		private String firstName;
		private String lastName;
		private String userName;
		private String passWord;
		private String role;
		
		public int getId() {return id;}
		public void setId(int id) {this.id = id;}
		
		public String getFirstName() {return firstName;}
		public void setFirstName(String firstName) {this.firstName = firstName;}
		
		public String getLastName() {return lastName;}
		public void setLastName(String lastName) {this.lastName = lastName;}
		
		public String getUserName() {return userName;}
		public void setUserName(String userName) {this.userName = userName;}
		
		public String getPassWord() {return passWord;}
		public void setPassWord(String passWord) {this.passWord = passWord;}
		
		public Object getRole() {return role;}
		public void setRole(String role) {this.role = role;}
		
		@Override
		public String toString() {
			return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
					+ userName + ", passWord=" + passWord + ", role=" + role + "]";
		}

		

		
		
		
		
		
}
