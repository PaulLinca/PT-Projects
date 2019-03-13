package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;

public class MonitoredData
{
	private Date startTime;
	private Date endTime;
	private String activity;
	
	public MonitoredData(String s)
	{
		String[] splitString = s.split("\t\t");
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try 
		{
			startTime = df.parse(splitString[0]);
			endTime = df.parse(splitString[1]);
			activity = splitString[2];
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString()
	{
		String s = "";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		s += df.format(startTime);
		s += "\t\t";
		s += df.format(endTime);
		s += "\t\t";
		s += activity;
		
		return s;
	}

	public DateTime duration()
	{
		DateTime dt1 = new DateTime(startTime);
		DateTime dt2 = new DateTime(endTime);
		
		DateTime result = new DateTime(dt2.getMillis() - dt1.getMillis());
		
		return result;
	}
	
	//returns the date of the starting time
	public int getStartDate()
	{
		return Integer.parseInt(startTime.toString().substring(8, 10));
	}
	
	//returns the date of the ending time
	public int getEndDate()
	{
		return Integer.parseInt(endTime.toString().substring(8, 10));
	}
	
	public Date getStartTime()
	{
		return startTime;
	}
	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
	}
	public Date getEndTime() 
	{
		return endTime;
	}
	public void setEndTime(Date endTime) 
	{
		this.endTime = endTime;
	}
	public String getActivity()
	{
		return activity;
	}
	public void setActivity(String activity) 
	{
		this.activity = activity;
	}
	
	
}
