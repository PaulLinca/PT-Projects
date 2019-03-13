package PT2018.assigment2.Assignment_2;

import controller.Simulation;

public class Main 
{
	public static void main(String[] args) 
	{
		//start the simulation
		Simulation sim = new Simulation();
		Thread th = new Thread(sim);
		th.start();
	}
}
