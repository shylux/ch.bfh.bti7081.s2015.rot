package ch.bfh.bti7081.s2015.red.PatientApp.App;

import java.util.Date;

public abstract class Activity extends CalendarEntry {
	protected Date softTimeLimit;
	protected Date hardTimeLimit;
	int givenPoints  = 0;
	boolean done;
	
	public abstract boolean checkSuccess();
}
