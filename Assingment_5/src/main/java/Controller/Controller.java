package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import Model.DataProcessor;
import View.View;

public class Controller
{
	private View view;
	private DataProcessor dp;
	
	public Controller()
	{
		view = new View();
		dp = new DataProcessor();
		
		dp.createList();
		
		task1();
		task2();
		task3();
		task4();
		task5();
	}
	
	public void task1()
	{
		view.getBtn1().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String result = "Number of days that the person has been monitored\n\n";
						result += "The person has been monitored for " + dp.distinctDays() + " days.";
												
						view.getTextArea().setText(result);
					}
				});
	}
	
	public void task2()
	{
		view.getBtn2().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String result = "Number of occurences of each of the person's actions\n\n";
						Map<String, Integer> actOcc = dp.actionOccurrences();
						for(String s: actOcc.keySet())
						{
							result += s + " occurences: " + actOcc.get(s) + "\n";
						}
						
						
						view.getTextArea().setText(result);
					}
				});
	}
	
	public void task3()
	{
		view.getBtn3().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String result = "Number of occurences of each of the person's actions for each day he has been monitored\n\n";
						
						Map<Integer, Map<String, Long>> dayC = dp.dayCount();
						
						for(Integer i: dayC.keySet())
						{
							result += "Day " + i + "\n";
							
							for(String s: dayC.get(i).keySet())
							{
								result += "\t " + s + ": " + dayC.get(i).get(s) + "\n";
							}
						}
						
						view.getTextArea().setText(result);
					}
				});
	}
	
	public void task4()
	{
		view.getBtn4().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String result = "Total duration of the activities (>10 hours)\n\n";
						
						Map<String, DateTime> activityTotal = dp.activityDuration();
						for(String s: activityTotal.keySet())
						{
							result += s + ": " + activityTotal.get(s).getMillis() /1000/60/60 + " hours.\n";
						}
						
						view.getTextArea().setText(result);
					}
				});
	}
	
	public void task5()
	{
		view.getBtn5().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String result = "Activities that have 90% of occurences lasting less than 5 minutes\n\n";
						
						List<String> u5 = dp.underFive();
						for(String s: u5)
						{
							result += s + "\n";
						}
						
						view.getTextArea().setText(result);
					}
					
				});
	}
}
