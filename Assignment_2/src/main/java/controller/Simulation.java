package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Customer;
import model.Queue;
import view.View;

public class Simulation implements Runnable
{
	
	private List<Queue> queueList;
	private List<Customer> customerList;
	private View view = new View();
	private int currTime = 0;
	private boolean running = false;
	private String finalLog = "";
	private int[] peakHour = {0, 0}; //[0] is the time and [1] is the number of customers
	
	public Simulation()
	{
		queueList = new ArrayList<Queue>();
		customerList = new ArrayList<Customer>();
		
		startButton();
	}
	//implements the the action listener for the start button
	public void startButton()
	{
		view.getBtnStart().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						System.out.println("Started");
						view.getLblStatus().setText("Simulation started;");
						
						generateQueues(Integer.parseInt(view.getTextQueues().getText()));
						generateRandomCustomers();
						
						for(Queue que: getQueueList())
						{
							Thread th = new Thread(que);
							th.start();
						}
						
						finalLog += "Simulation started;\n";
						
						setRunning(true);
					}
				});
	}
	//generates the queues 
	public void generateQueues(int maxQueues)
	{
		for(int i = 0; i < maxQueues; i++)
		{
			getQueueList().add(new Queue());
		}
	}
	//generates the customers randomly
	public void generateRandomCustomers()
	{
		Random rand = new Random();
		int noOfCustomers = rand.nextInt(Integer.parseInt(view.getTextCustomers().getText())) + 1;
		
		for(int i = 0; i < noOfCustomers; i++)
		{
			int arrTime = rand.nextInt(Integer.parseInt(view.getTextArrival2().getText()) - 1) + Integer.parseInt(view.getTextArrival1().getText());
			int servTime = rand.nextInt(Integer.parseInt(view.getTextService2().getText())) + Integer.parseInt(view.getTextService1().getText());
			
			customerList.add(new Customer(arrTime, servTime));
		}
	}
	//run method
	public void run()
	{	
		boolean waiting = true;
		int totalWait = 0, emptyQTime = 0;
		while(waiting)
		{
			System.out.println("Press start;");
			while(running){
				int avgService = averageService();
				for(int i = 0; i <= Integer.parseInt(view.getTextSimulation1().getText()); i++)
				{
					addCustomerToList(currTime);
					currTime++;
					int avg[] = computeAverages(totalWait, emptyQTime);
					emptyQTime = avg[0];
					totalWait = avg[1];
					computePeak();
					try
					{
						Thread.sleep(1000);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
				waiting = false;
				printLog(emptyQTime, totalWait, avgService);
			}
		}
	}
	//computed the peak hour for the simulation
	public void computePeak()
	{
		int currNoCust = 0;
		for(Queue que: getQueueList())
		{
			for(Customer cust: que.getCustomerQueue())
			{
				currNoCust++;
			}
		}

		if(currNoCust > peakHour[0]) 
		{
			peakHour[0] = currNoCust;
			peakHour[1] = currTime;
		}
	}
	//computes the average service time and returns it
	public int averageService()
	{
		int total = 0;
		
		for(Customer cust: getCustomerList())
		{
			total += cust.getServingTime();
		}
		
		return (total/getCustomerList().size());
	}
	//prints the final log on the text area of the gui
	public void printLog(int emptyQTime, int totalWait, int avgService)
	{
		setRunning(false);
		
		finalLog += "\n";
		finalLog += "Peak hour was at " + peakHour[1] + " seconds with " + peakHour[0] + " customers " + ";\n";
		finalLog += "Average customer service time: " + avgService + ";\n";
		finalLog += "Average time the queues were empty: " + (float)(emptyQTime/Integer.parseInt(view.getTextQueues().getText())) + ";\n";
		finalLog += "Average waiting time: " + (float)(totalWait/getCustomerList().size()) + ";\n";
		
		view.getTextArea().setText(finalLog);
	}
	//computes the required averages for the final log
	public int[] computeAverages(int totalWait, int emptyQTime)
	{
		int avg[] = new int[2];
		for(Queue que: getQueueList())
		{
			if(que.getCustomerQueue().size() == 0)
				emptyQTime++;
			else
			{
				for(Customer cust: que.getCustomerQueue())
				{
					if(cust.getServingTime() == 1)
					{
						totalWait += cust.getWaitingTime() + 1;
						
						finalLog += currTime + ": " + "Customer("+ cust.getArrivalTime() + ", " + cust.getServingTime() + ") left the queue;\n";
					}
					else
					{
						cust.setWaitingTime(cust.getWaitingTime() + 1);
					}
				}
			}
		}
		avg[0] = emptyQTime;
		avg[1] = totalWait;
		return avg;
	}
	//adds customer to the min list and updates the log and the status label
	public void addCustomerToList(int currTime)
	{
		for(Customer currCust: customerList)
		{
			if(currCust.getArrivalTime() == currTime)
			{
				finalLog += currTime + ": " + "Customer("+ currCust.getArrivalTime() + ", " + currCust.getServingTime() + ") added to queue " + getMinQueue() + "\n";
				queueList.get(getMinQueue()).addCustomer(currCust);
			}
		}

		statusUpdate(currTime);
	}
	//updates the status label and the log
	public void statusUpdate(int currTime)
	{
		
		if(currTime == Integer.parseInt(view.getTextArrival1().getText()))
		{
			finalLog += currTime + ": Customers start coming\n";
			view.getLblStatus().setText("Customers will start coming now;");
		}
		
		if(currTime == Integer.parseInt(view.getTextArrival2().getText()))
		{
			finalLog += currTime + ": Customers stop coming\n";
			view.getLblStatus().setText("Customers will stop coming");
		}
		
		if(currTime == Integer.parseInt(view.getTextSimulation1().getText()))
		{
			finalLog += currTime + ": Simulation finished\n";
			view.getLblStatus().setText("Simulation finished");
		}
		
		view.getLblTimer().setText(currTime + "");
		view.getTextArea().setText(printQueues());
	}
	//returns the queue with the least customers 
	public int getMinQueue()
	{
		int min = 999;
		int minIndex = -1;
		int i = 0;
		
		for(Queue que: this.getQueueList())
		{
			int size = que.getCustomerQueue().size();
			if(size < min)
			{
				min = size;
				minIndex = i;
			}
			i++;
		}		
		return minIndex;
	}
	//returns a string containing the queues and their customers
	public String printQueues()
	{
		String finalString = "";
		
		for(Queue que: this.getQueueList())
		{
			finalString += "Queue: ";
			for(Customer cust: que.getCustomerQueue())
			{
				finalString += cust.toString();
			}
			finalString += '\n';
		}
		
		return finalString;
	}
	
	//getters and setters
	public int getCurrTime()
	{
		return currTime;
	}

	public List<Queue> getQueueList() 
	{
		return queueList;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}
}
