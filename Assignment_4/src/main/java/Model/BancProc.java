package Model;

import java.util.Set;

public interface BancProc
{
	public void addPerson(Person person);
	
	public void removePerson(int SSN);
	
	public void addAccount(Person person, Account account);
	
	public void removeAccount(int ID);
	
	public Set<Account> getAccounts();
	
	public Set<Person> getPersons();
	
	public Set<Account> getAccountsFromPerson(Person person);
	
	public void deposit(int id, double sum);
	
	public void withdraw(int id, double sum);
}
