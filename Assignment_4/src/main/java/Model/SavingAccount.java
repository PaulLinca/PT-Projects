package Model;

public class SavingAccount extends Account
{	
	private static final long serialVersionUID = 1L;
	
	private final double interestRate = 0.05;
	private int months;
	private boolean hasWithdrawn = false;
	
	public SavingAccount(int accountId, double balance, int period)
	{
		super(accountId, balance);
		this.setMonths(period);
	}
	
	public void depositFunds(double sum)
	{
		if(hasWithdrawn == false && this.getBalance() == 0 && sum > 500)
		{
			this.setBalance(sum);
			this.setBalance(this.getBalance() + (sum * interestRate * months));
			/*
			this.setChanged();
			this.notifyObservers();
			*/
		}
		else
		{
			System.out.println("You cannot deposit in this account anymore or the sum is too little");
		}

	}
	
	public void withdrawFunds(double sum)
	{
		if(this.getBalance() - sum >= 0 && hasWithdrawn == false)
		{
			this.setBalance(getBalance() - sum);
			hasWithdrawn = true;
			/*
			this.setChanged();
			this.notifyObservers();
			*/
		}
		else
		{
			System.out.println("You cannot withdraw from this account anymore.");
		}
	}
	
	public String toString()
	{
		String returnString = "";
		
		returnString += "A(id: ";
		returnString += getAccountId();
		returnString += ", Balance: ";
		returnString += getBalance();
		returnString += ", Period: ";
		returnString += getMonths();
		returnString += " months)";
		
		return returnString;
	}
	
	public int getMonths()
	{
		return months;
	}

	public void setMonths(int months) 
	{
		this.months = months;
	}

	public double getInterestRate() {
		return interestRate;
	}
	
	
}
