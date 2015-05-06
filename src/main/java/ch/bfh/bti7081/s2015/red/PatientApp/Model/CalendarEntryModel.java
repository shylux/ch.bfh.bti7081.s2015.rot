package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import ch.bfh.bti7081.s2015.red.PatientApp.App.CalendarEntry;


public class CalendarEntryModel implements Model {

	protected CalendarEntry calendarEntry;
	
	
	@Override
	public void update(Object data) {
		// TODO Auto-generated method stub
		calendarEntry = (CalendarEntry)data;
	}

	@Override
	public Object getData() {
		// TODO Auto-generated method stub
		return calendarEntry;
	}

}
