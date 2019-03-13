package Model;

public class SpendingAccount extends Account
{
	private static final long serialVersionUID = 1L;

	public SpendingAccount(int accountId, double balance)
	{
		super(accountId, balance);
	}
	
	public void depositFunds(double sum)
	{
		this.setBalance(this.getBalance() + sum);
		
		/*
		this.setChanged();
		this.notifyObservers();
		*/
	}
	
	public void withdrawFunds(double sum)
	{
		if(this.getBalance() - sum >= 0)
		{
			this.setBalance(getBalance() - sum);
			
			/*
			this.setChanged();
			this.notifyObservers();
			*/
		}
		else 
		{
			//
		}
	}
}
