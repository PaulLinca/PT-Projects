package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Set;

import Model.Account;
import Model.Bank;
import Model.Person;
import Model.SavingAccount;
import Model.SpendingAccount;
import Serializer.Serialization;
import View.View;

public class Controller
{
	private View view;
	private Bank bank;
	
	public Controller()
	{
		view = new View();
		bank = new Bank();
		
		Serialization ser = new Serialization();
		bank = ser.deserializeBank();
		
		tablePerson();
		tableAccount();
		
		addPerson();
		addSpending();
		addSaving();
		
		deposit();
		withdraw();
		
		delPers();
		delAcc();
		
		clickPerson();
		clickAccount();
		
		editPerson();
	}
	
	public void tablePerson()
	{
		int rowCount = view.getModel().getRowCount();
		
		for(int i = rowCount - 1; i >= 0; i--)
		{
			view.getModel().removeRow(i);
		}
		
		Set<Person> set = bank.getPersons();
		for(Person per: set)
		{
			Object[] obj = {per.getName(), per.getEmail(), per.getSSN()};
			view.getModel().addRow(obj);
		}
	}
	
	public void tableAccount()
	{
		int rowCount = view.getModel1().getRowCount();
		
		for(int i = rowCount - 1; i >= 0; i--)
		{
			view.getModel1().removeRow(i);
		}
		
		Set<Account> set = bank.getAccounts();
		for(Account acc: set)
		{
			Object[] obj = {acc.getAccountId(), acc.getBalance()};
			view.getModel1().addRow(obj);
		}
	}
	
	
	
	public void addPerson()
	{
		view.getBtnAddPerson().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						Person pers = new Person(view.getTextName().getText(), view.getTextEmail().getText(), view.getTextSSN().getText());
						bank.addPerson(pers);
						Object[] obj = {view.getTextName().getText(), view.getTextEmail().getText(), view.getTextSSN().getText()};
						view.getModel().addRow(obj);
					}
				}
				);
	}
	
	public void addSpending()
	{
		view.getBtnAddSpending().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						Random rand = new Random();
						Person pers = new Person(view.getTextName1().getText(), view.getTextEmail1().getText(), view.getTextSSN1().getText());
						if(bank.getBankData().containsKey(pers))
						{
							SpendingAccount sp = new SpendingAccount(rand.nextInt(10000) + 1, 0);
							bank.addAccount(pers, sp);
							Object[] obj = {sp.getAccountId(), sp.getBalance()};
							view.getModel1().addRow(obj);
						}
					}
				}
				);
	}
	
	public void addSaving()
	{
		view.getBtnAddSaving().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						Random rand = new Random();
						Person pers = new Person(view.getTextName1().getText(), view.getTextEmail1().getText(), view.getTextSSN1().getText());
						if(bank.getBankData().containsKey(pers))
						{
							SavingAccount sp = new SavingAccount(rand.nextInt(10000) + 1, 0, Integer.parseInt(view.getTextPeriod().getText()));
							bank.addAccount(pers, sp);
							Object[] obj = {sp.getAccountId(), sp.getBalance()};
							view.getModel1().addRow(obj);
						}
					}
				}
				);
	}
	
	public void deposit()
	{
		view.getBtnDeposit().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						bank.deposit(Integer.parseInt(view.getTextID().getText()), Double.parseDouble(view.getTextAmount().getText()));
						tableAccount();
					}
				}
				);
	}
	
	public void withdraw()
	{
		view.getBtnWdraw().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						bank.withdraw(Integer.parseInt(view.getTextID1().getText()), Double.parseDouble(view.getTextAmount1().getText()));
						tableAccount();
					}
				}
				);
	}
	
	public void delPers()
	{
		view.getBtnDelPers().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						bank.removePerson(Integer.parseInt(view.getTextDelSSN().getText()));
						tablePerson();
						tableAccount();
					}
				}
				);
	}
	
	public void delAcc()
	{
		view.getBtnDelAcc().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						bank.removeAccount(Integer.parseInt(view.getTextDelID().getText()));
						tableAccount();
					}
				}
				);
	}
	
	public void clickPerson()
	{
		view.getTable().addMouseListener(
				new MouseAdapter()
				{
					public void mouseClicked(MouseEvent evt)
					{
						int row = view.getTable().rowAtPoint(evt.getPoint());
						Object[] persons = bank.getBankData().keySet().toArray();
						view.getLblAccs().setText(bank.getBankData().get(persons[row]).size() + "");
					}
				}
				);
	}
	
	public void clickAccount()
	{
		view.getTable1().addMouseListener(
				new MouseAdapter()
				{
					public void mouseClicked(MouseEvent evt)
					{
						int row = view.getTable().rowAtPoint(evt.getPoint());
						for(Set<Account> set : bank.getBankData().values())
						{
							for(Account acc: set)
							{
								if(row == 0)
								{
									view.getLblType().setText(acc.getClass().getSimpleName());;
								}
							}
						}
					}
				}
				);
	}
	
	public void editPerson()
	{
		view.getBtnEdit().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						Person pers = new Person(view.getTextName().getText(), view.getTextEmail().getText(), view.getTextSSN().getText());
						for(Person p: bank.getBankData().keySet())
						{
							if(p.getSSN().equals(pers.getSSN()))
							{
								Set<Account> set = bank.getBankData().get(p);
								bank.removePerson(Integer.parseInt(pers.getSSN()));
								bank.addPerson(pers);
								for(Account acc: set)
								{
									bank.addAccount(pers, acc);
								}
							}
						}
						tablePerson();
					}
				}
				);
	}
}
