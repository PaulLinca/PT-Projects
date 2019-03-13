package Model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class Bank implements BancProc, Serializable
{
	private static final long serialVersionUID = 1L;
	
	private HashMap<Person,Set<Account>> bankData;
	
	public Bank()
	{
		bankData = new HashMap<Person, Set<Account>>();
	}

	public boolean wellFormed()
	{
		for(Person p: bankData.keySet())
		{
			if(p == null)
			{
				return false;
			}
			for(Account acc: bankData.get(p))
			{
				if(acc.getBalance() < 0)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public void addPerson(Person person)
	{
		
		assert wellFormed();
		assert person != null;
		
		if(!bankData.containsKey(person))
		{
			Set<Account> set = new HashSet<Account>();
			bankData.put(person, set);
			System.out.println("Person " + person.toString() + " has been added.");
		}
		
		assert bankData.containsKey(person);
		assert wellFormed();
	}

	public void removePerson(int ssn)
	{
		assert wellFormed();
		assert ssn > 0;
		
		Person person = null;
		
		for(Person p: bankData.keySet())
		{
			if(Integer.parseInt(p.getSSN()) == ssn)
			{
				person = p;
			}
		}

		if(person != null)
		{
			bankData.remove(person);
			System.out.println("Person " + person.toString() + " has been deleted.");
		}
		else
		{
			System.out.println("Person does not exist.");
		}
		
		assert !bankData.containsKey(person);
		assert wellFormed();
	}

	public void addAccount(Person person, Account account) 
	{
		assert wellFormed();
		assert person != null;
		assert account != null;
		
		int ok = 0;
		
		if(bankData.containsKey(person))
		{
			Set<Account> personsAccounts = bankData.get(person);
			personsAccounts.add(account);
			
			//addObservers();
			System.out.println("Account " + account.toString() + " has been added by " + person.toString() + " successfully.");
		}
		else
		{
			System.out.println("Person " + person.toString()+ " does not exist.");
		}
		
		for(Person p: bankData.keySet())
		{
			for(Account a: bankData.get(p))
			{
				if(a == account)
				{
					ok = 1;
				}
			}
		}
		
		assert ok == 1;
		assert wellFormed();
	}

	public void removeAccount(int id)
	{		
		assert id > 0;
		assert wellFormed();
		
		for(Set<Account> set: bankData.values())
		{
			for(Account acc: set)
			{
				if(acc.getAccountId() == id)
				{
					set.remove(acc);
					System.out.println("Account " + acc + " has been removed.");
				}
			}
		}
		
		assert wellFormed();
	}
	 
	public Set<Person> getPersons() 
	{
		Set<Person> persons = new HashSet<Person>();
		
		for(Person person : bankData.keySet())
		{
			persons.add(person);
		}
		
		return persons;
	}

	public Set<Account> getAccountsFromPerson(Person person) 
	{
		if(bankData.containsKey(person))
		{
			return bankData.get(person);
		}
		return null;
	}

	public HashMap<Person, Set<Account>> getBankData()
	{
		return bankData;
	}

	public void setBankData(HashMap<Person, Set<Account>> bankData) {
		this.bankData = bankData;
	}

	public Set<Account> getAccounts() 
	{
		Set<Account> accounts = new HashSet<Account>();
		
		for(Set<Account> set: bankData.values())
		{
			for(Account acc: set)
			{
				accounts.add(acc);
			}
		}
		
		return accounts;
	}

	public void deposit(int id, double sum)
	{
		assert wellFormed();
		assert id > 0;
		assert sum > 0;
		
		for(Set<Account> set: bankData.values()) 
		{
			for(Account acc: set)
			{
				if(acc.getAccountId() == id)
				{
					acc.depositFunds(sum);
					assert acc.getBalance() >= sum;
					System.out.println(sum + " moneys have been deposited in the account " + id);
				}
			}
		}
		
		assert wellFormed();
	}

	public void withdraw(int id, double sum)
	{
		assert wellFormed();
		assert id > 0;
		assert sum > 0;
		
		for(Set<Account> set: bankData.values()) 
		{
			for(Account acc: set)
			{
				if(acc.getAccountId() == id)
				{
					acc.withdrawFunds(sum);
					System.out.println(sum + " moneys have been withdrawn from the account " + id);
				}
			}
		}
		
		assert wellFormed();
	}

	/*
	public void addObservers()
	{
		for(Person p: bankData.keySet())
		{
			for(Account a: bankData.get(p))
			{
				a.addObserver(p);
			}
		}
	}
	*/
	
}
