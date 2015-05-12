package ch.bfh.bti7081.s2015.red.PatientApp.App;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.CalendarEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.MedicationEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Emergency;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Patient;

public class PatientApp {
	private Calendar calendar = new Calendar();
	private LifeUp lifeUp = new LifeUp();
	private Emergency emergency = new Emergency();
	private Patient patient = new Patient();
	
	/**
	 * get all events from today
	 * @return
	 */
	public ArrayList<CalendarEntry>getDailyEvents()
	{
		return null;
	}
	/**
	 * update the data of a specific activity
	 * @param activity
	 */
	public void updateActivity(Activity activity)
	{
		
	}
}
