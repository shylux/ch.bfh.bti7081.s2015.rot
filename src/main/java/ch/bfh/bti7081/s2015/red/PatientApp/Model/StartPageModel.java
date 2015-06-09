package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import ch.bfh.bti7081.s2015.red.PatientApp.App.Calendar;
import ch.bfh.bti7081.s2015.red.PatientApp.App.PatientApp;

import java.util.ArrayList;
import java.util.Date;

/**
 * The model for the StartPage.
 * @author Stefan Tanner
 *
 */		
public class StartPageModel {

	private ArrayList<CalendarEntry> collection = new ArrayList<CalendarEntry>(); 
	private CalendarEntry current;
	private int intCurrentPosition = 0;
 
	/**
	 * Creates the StartPageModel an gets the data from the calendar.
	 */	
	public StartPageModel() {
		
		Calendar calendar = PatientApp.getInstance().getCalendar();
		collection = calendar.getEntriesStartingOnDay(new Date());
		
		if ( collection.size() == 0 ) { 
			Appointment dummy = new Appointment();
			dummy.setDescription("Momentan haben Sie keine Termine vorhanden.");
			dummy.setShortName("Freizeit");
			collection.add(dummy);
		}

		current = collection.get(0);
	}
	
	/**
	 * Returns the current CalendarEntry
	 *   
	 * @return	CalendarEntry	returns the current CalendarEntry
	 * @see		CalendarEntry
	 */	
	public CalendarEntry current() { 
		return current;
	}
	
	
	/**
	 * Returns the next CalendarEntry
	 *   
	 * @return	CalendarEntry	returns the next CalendarEntry
	 * @see		CalendarEntry
	 */		
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
	
	/**
	 * Returns the previous CalendarEntry
	 *   
	 * @return	CalendarEntry	returns the previous CalendarEntry
	 * @see		CalendarEntry
	 */		
	public CalendarEntry previous(CalendarEntry data) { 

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
