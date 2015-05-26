package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import ch.bfh.bti7081.s2015.red.PatientApp.App.Calendar;

import java.util.ArrayList;

public class StartPageModel {

	private ArrayList<CalendarEntry> collection = new ArrayList<CalendarEntry>(); 
	
	private CalendarEntry current;
	private int intCurrentPosition = 0;
 
	public StartPageModel() {
		
		Calendar calendar = new Calendar();
		
		System.out.println("CollectionSize() " + collection.size());
		System.out.println("Calender() " + calendar);
		
		collection = calendar.getTodayEntries();
		if ( collection.size() == 0 ) {
			
			Appointment dummy0 = new Appointment();
			dummy0.setDescription("Besprechung Dr. Wechsler Rückfall"); 
			dummy0.setShortName("Sprechstunde");
			collection.add(dummy0);
			
			Appointment dummy1 = new Appointment();
			dummy1.setShortName("Gehen Sie einkaufen!"); 
			dummy1.setDescription("Sie haben dafür Zeit bis um 19:00");
			collection.add(dummy1);
			
			Appointment dummy2 = new Appointment();
			dummy2.setShortName("Wohnung aufräumen");
			dummy2.setDescription("Putzen Sie Ihre Wohnung, entsorgen Sie ausserdem das Altglas");
			collection.add(dummy2);		
			
		}
		
		if ( collection.size() == 0 ) { 
			Appointment dummy = new Appointment();
			dummy.setDescription("Momentan haben Sie keine Termine vorhanden.");
			dummy.setShortName("Freizeit");
			collection.add(dummy);
		}

		System.out.println("CollectionSize() " + collection.size());
		
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
