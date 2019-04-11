package com.revature.beans;

public class Customer 
{
	
	    private Customer customer = new Customer();
	    
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
		
		@Override
		public String toString() {
			return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
					+ userName + ", passWord=" + passWord + "]";
		}
		public Customer add(Customer newCustomer) 
		{
			// Verify that there are no empty fields
			if (newCustomer.getUserName().equals("") 
					|| newCustomer.getPassWord().equals("") 
					|| newCustomer.getFirstName().equals("")
					|| newCustomer.getLastName().equals("")) 
			{
			return customer.add(newCustomer);
			}
		return newCustomer;
		}

		
		
		
		
		
}
