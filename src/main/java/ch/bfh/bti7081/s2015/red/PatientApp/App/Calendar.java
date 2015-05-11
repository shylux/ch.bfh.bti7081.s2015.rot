package ch.bfh.bti7081.s2015.red.PatientApp.App;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.CalendarEntry;

public class Calendar {
	private ArrayList<CalendarEntry>entries = new ArrayList<CalendarEntry>();
	public ArrayList<CalendarEntry> getDailyEntries()
	{
		return entries;
		
	}
	public ArrayList<CalendarEntry> getTomorrowEntries()
	{
		return entries;
	}
	public void updateCalendarEntries()
	{
		
	}
	
}
