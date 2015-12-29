package com.infy.spring;

public class CustomerBean implements Comparable<CustomerBean>{
	
	private long mobileNumber;
	private String region;
	private double amount;
	private String email;
	
	
	public CustomerBean(){
		
	}
	
	public CustomerBean(long mobileNumber,String region,double amount,String email)
	{
		this.mobileNumber=mobileNumber;
		this.region=region;
		this.amount=amount;
		this.email=email;
	}
	
	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int compareTo(CustomerBean cust) {
		int compareNumber=(int) ((CustomerBean)cust).getMobileNumber();
		return (int) (this.mobileNumber-compareNumber);
	}

	@Override
	public String toString(){
		  return mobileNumber+" "+region+" "+amount +" "+email;  
		 }

	

}
