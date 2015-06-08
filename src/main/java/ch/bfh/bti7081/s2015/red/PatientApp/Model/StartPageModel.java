package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import ch.bfh.bti7081.s2015.red.PatientApp.App.Calendar;
import ch.bfh.bti7081.s2015.red.PatientApp.App.PatientApp;

import java.util.ArrayList;
import java.util.Date;

/**
 * Holds default data for development.
 */
public class StartPageModel {

	private ArrayList<CalendarEntry> collection = new ArrayList<CalendarEntry>(); 
	
	private CalendarEntry current;
	private int intCurrentPosition = 0;
 
	public StartPageModel() {
		
		Calendar calendar = PatientApp.getInstance().getCalendar();
		
		System.out.println("CollectionSize() " + collection.size());
		System.out.println("Calender() " + calendar);

		 collection = calendar.getEntriesStartingOnDay(new Date());
		
		
		if ( collection.size() == 0 ) { 
			Appointment dummy = new Appointment();
			dummy.setDescription("Momentan haben Sie keine Termine vorhanden.");
			dummy.setShortName("Freizeit");
			collection.add(dummy);
		}

		current = collection.get(0);
	}
	
	public CalendarEntry current() { 
		return current;
	}
	
	public CalendarEntry next(CalendarEntry data) { 
		 
		if ( collection.size() - 1 == intCurrentPosition ) {
			intCurrentPosition = 0;
			return collection.get(0);
		}
		else {
			intCurrentPosition++;
			return collection.get(intCurrentPosition);
		}
 
	}

	public CalendarEntry previous(CalendarEntry data) {
		// TODO Auto-generated method stub

		if ( intCurrentPosition == 0 ) {
			intCurrentPosition = collection.size() - 1;
			return collection.get(intCurrentPosition);
		}
		else {
			intCurrentPosition--;
			return collection.get(intCurrentPosition);
		}

		
	}
	
	
	
	
	
	
	
	
}
