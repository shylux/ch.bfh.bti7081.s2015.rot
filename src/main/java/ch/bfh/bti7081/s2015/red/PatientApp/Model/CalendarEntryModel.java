package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import java.util.ArrayList;
import java.util.Collections;

import ch.bfh.bti7081.s2015.red.PatientApp.App.CalendarEntry;


public class CalendarEntryModel implements Model<CalendarEntry> {

	protected ArrayList<CalendarEntry> entries = new ArrayList<CalendarEntry>();
	

	@Override
	public void update(CalendarEntry data) {
		int index = entries.indexOf(data);
		entries.set(index, data);
	}





	@Override
	public ArrayList<CalendarEntry> getCollection() {
	
		//TODO: only get a copy of the entries back...
		//IMPORTANT:  fix ASAP
		ArrayList<CalendarEntry> tmpEntries = new ArrayList<>();
		 for(CalendarEntry c : entries)
	    {   
			 tmpEntries.add(c);
	    }
		
		return tmpEntries;
	}



	@Override
	public void add(CalendarEntry o) {
		entries.add(o);
		
	}


	@Override
	public CalendarEntry getData() {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public void update(ArrayList<CalendarEntry> collection) {
		entries = collection;
		
	}



}
