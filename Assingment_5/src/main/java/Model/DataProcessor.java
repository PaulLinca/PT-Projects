package Model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.joda.time.DateTime;

public class DataProcessor
{
	private List<MonitoredData> dataList;
	
	public DataProcessor()
	{
		dataList = new ArrayList<>();
	}
	
	public void createList()
	{
		String fileName = "Activities.txt";
		
		try(Stream<String> stream = Files.lines(Paths.get(fileName)))
		{
			stream.forEach((String line) -> dataList.add(new MonitoredData(line)));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public int distinctDays()
	{
		List<String> days = new ArrayList<>();
		
		for(MonitoredData md: dataList)
		{
			days.add(md.getStartTime().toString().substring(0, 10));
			days.add(md.getEndTime().toString().substring(0, 10));
		}
		
		List<String> s = days.stream()
								.distinct()
								.collect(Collectors.toList());
		
		return s.size();
	}
	
	public Map<String, Integer> actionOccurrences()
	{
		Map<String, Integer> actions = new HashMap<>();
		
		//go through each activity
		for(MonitoredData md1: dataList)
		{
			//how many times has md1's activity happened in the monitoring period
			int occurrences = dataList.stream()
						.filter(md -> md.getActivity().equals(md1.getActivity()))
						.collect(Collectors.toList()).size();
			
			actions.put(md1.getActivity(), occurrences);
		}
		
		return actions;
	}
	
	public Map<Integer, Map<String, Long>> dayCount()
	{
		Map<Integer, Map<String, Long>> count = new HashMap<>();
		
//		count = dataList.stream()
//				.collect(Collectors.groupingBy(MonitoredData::getStartDate, Collectors.groupingBy(MonitoredData::getActivity, Collectors.counting())));
		
		count = dataList.stream()
							.collect(Collectors.groupingBy(md -> md.getStartDate(), Collectors.groupingBy(md -> md.getActivity(), Collectors.counting())));
		
		
		return count;
	}

	public Map<String, DateTime> activityDuration()
	{
		Map<String, DateTime> duration = new HashMap<>();

		for(MonitoredData md1: dataList)
		{
			long dur = dataList.stream()
								.filter(md -> md.getActivity().equals(md1.getActivity()))
								.map(md -> md.duration())
								.mapToLong(dt -> dt.getMillis()).sum();
			
			
			
			
			if(dur/1000/60 >= 600)
			{
				duration.put(md1.getActivity(), new DateTime(dur));
			}			
		}
		
//		duration = dataList.stream()
//					.collect(Collectors.toMap(md -> ((MonitoredData) md).getActivity(), md -> md.duration(), (p1, p2)->p1));
//				
		
		return duration;
	}
	
	public List<String> underFive()
	{
		List<String> result = new ArrayList<>();
		
		for(MonitoredData md1: dataList)
		{
			List<MonitoredData> all = dataList.stream()
												.filter(md->md.getActivity().equals(md1.getActivity()))
												.collect(Collectors.toList());
			
			List<MonitoredData> allFiltered = all.stream()
					.filter(md -> md.duration().getMillis() < 300000)
					.collect(Collectors.toList());
			
			if(allFiltered.size() >= all.size() * 9/10 && !result.contains(md1.getActivity()))
			{
				result.add(md1.getActivity());
			}
	
		}
		
		for(String s: result)
		{
			System.out.println(s);
		}
		
		return result;
	}
	
	public List<MonitoredData> getDataList() {
		return dataList;
	}

	public void setDataList(List<MonitoredData> dataList) {
		this.dataList = dataList;
	}
	
	
}

