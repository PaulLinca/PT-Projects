package model;

import java.util.ArrayList;
import java.util.List;

public class Queue implements Runnable
{
	private List<Customer> customerQueue;
	
	public Queue()
	{
		customerQueue = new ArrayList<Customer>();
	}
	
	//the first customer in line gets its waiting time decremented every second and when it reaches 0 he gets deleted 
	public void run() 
	{
		while(true)
		{
			if(getCustomerQueue().size() > 0)
			{
				Customer currCustomer = getCustomerQueue().get(0);
				while(currCustomer.getServingTime() > 1)
				{
					currCustomer.setServingTime(currCustomer.getServingTime() - 1);
					try
					{
						Thread.sleep(1000);
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				}
				delCustomer();
			}
			else
			{
				try
				{
					Thread.sleep(1000);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	//adds a customer in the queue
	public void addCustomer(Customer c)
	{
		getCustomerQueue().add(c);
	}
	
	//deletes first customer in the queue
	public void delCustomer()
	{
		getCustomerQueue().remove(0);
	}

	public List<Customer> getCustomerQueue() 
	{
		return customerQueue;
	}

	public void setCustomerQueue(List<Customer> customerQueue)
	{
		this.customerQueue = customerQueue;
	}

	
}
