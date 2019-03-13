package model;

public class Customer 
{
	private int arrivalTime;
	private int servingTime;
	private int waitingTime = 0;
	
	public Customer(int arrivalTime, int servingTime)
	{
		setServingTime(servingTime);
		setArrivalTime(arrivalTime);
	}
	
	public int getWaitingTime()
	{
		return waitingTime;
	}
	
	public void setWaitingTime(int waitingTime)
	{
		this.waitingTime = waitingTime;
	}
	
	public int getArrivalTime() 
	{
		return arrivalTime;
	}
	
	public void setArrivalTime(int arrivalTime) 
	{
		this.arrivalTime = arrivalTime;
	}
	
	public int getServingTime() 
	{
		return servingTime;
	}
	
	public void setServingTime(int servingTime)
	{
		this.servingTime = servingTime;
	}
	
	public String toString()
	{
		
		return "C(" + getArrivalTime() + ", " + getServingTime() + ") " + " - ";
	}
}
