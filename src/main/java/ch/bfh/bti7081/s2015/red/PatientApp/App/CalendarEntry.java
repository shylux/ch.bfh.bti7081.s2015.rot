package ch.bfh.bti7081.s2015.red.PatientApp.App;

import java.util.Date;

public abstract class CalendarEntry {
	
	public abstract String display();
	
	protected Date startTime;
	protected Date endTime;
	protected String shortName;
	protected String description;
	
	
}
