package PT2018.Assignment4.Assignment4;
import Model.Account;
import Model.Bank;
import Model.Person;
import Model.SpendingAccount;
import junit.framework.TestCase;

public class AppTest  extends TestCase
{
    public void testAddPerson()
    {
        Bank bank = new Bank();
        Person person1 = new Person("Paul", "linca_paul", "123456789");
        
        bank.addPerson(person1);
        
        assertTrue(bank.getBankData().containsKey(person1));
    }
    
    public void testRemovePerson()
    {
    	Bank bank = new Bank();
        Person person1 = new Person("Paul", "linca_paul", "123456789");
        
        bank.addPerson(person1);
        
        bank.removePerson(Integer.parseInt(person1.getSSN()));
        
        assertFalse(bank.getBankData().containsKey(person1));
    }
    
    public void testAddAccount()
    {
    	Bank bank = new Bank();
        Person person1 = new Person("Paul", "linca_paul", "123456789");
        
        bank.addPerson(person1);
        
        Account acc = new SpendingAccount(123, 100);
        
        bank.addAccount(person1, acc);
        
        assertTrue(bank.getBankData().get(person1).contains(acc));
    }
    
    public void testRemoveAccount()
    {
    	Bank bank = new Bank();
        Person person1 = new Person("Paul", "linca_paul", "123456789");
        
        bank.addPerson(person1);
        
        Account acc = new SpendingAccount(123, 100);
        
        bank.addAccount(person1, acc);
        bank.removeAccount(acc.getAccountId());
        
        assertFalse(bank.getBankData().get(person1).contains(acc));
    }
    
    public void testDeposit()
    {
    	Bank bank = new Bank();
        Person person1 = new Person("Paul", "linca_paul", "123456789");
        
        bank.addPerson(person1);
        
        Account acc = new SpendingAccount(123, 100);
        
        bank.addAccount(person1, acc);
        bank.deposit(acc.getAccountId(), 200);
        
        Object[] o = bank.getBankData().get(person1).toArray();
        
        assertEquals(o[0].toString(), "A(id: 123, Balance: 300.0)");
    }
    
    public void testWithdraw()
    {
    	Bank bank = new Bank();
        Person person1 = new Person("Paul", "linca_paul", "123456789");
        
        bank.addPerson(person1);
        
        Account acc = new SpendingAccount(123, 100);
        
        bank.addAccount(person1, acc);
        bank.withdraw(acc.getAccountId(), 50);
        
        Object[] o = bank.getBankData().get(person1).toArray();
        
        assertEquals(o[0].toString(), "A(id: 123, Balance: 50.0)");
    }
}
