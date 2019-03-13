package Model;

import java.io.Serializable;
import java.util.Observable;

public abstract class Account extends Observable implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int accountId;
	private double balance;
	
	public Account(int accountId, double balance)
	{
		this.accountId = accountId;
		this.balance = balance;
	}
	
	public String toString()
	{
		String returnString = "";
		
		returnString += "A(id: ";
		returnString += getAccountId();
		returnString += ", Balance: ";
		returnString += getBalance();
		returnString += ")";
		
		return returnString;
	}

	public int getAccountId() 
	{
		return accountId;
	}

	public void setAccountId(int accountId)
	{
		this.accountId = accountId;
	}

	public double getBalance() 
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	
	public abstract void depositFunds(double sum);
	
	public abstract void withdrawFunds(double sum);
}
