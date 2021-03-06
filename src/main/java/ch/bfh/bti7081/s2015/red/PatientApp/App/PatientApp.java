package ch.bfh.bti7081.s2015.red.PatientApp.App;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.LifeUp;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.CalendarEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Emergency;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Patient;




/**
 * public interface for the patient app
 * all relevant data are stored here
 * @author James Mayr
 *
 */
public class PatientApp {
	
	private static PatientApp patientAppInstance = null;
	
	public static PatientApp getInstance()
	{
		if(patientAppInstance == null)
		{
			patientAppInstance = new PatientApp();
		}
		return patientAppInstance;
	}
	
	private PatientApp(){}
	
	private Calendar calendar = new Calendar();
	private LifeUp lifeUp = new LifeUp();
	private Emergency emergency = new Emergency();
	private Patient patient = new Patient();

	/**
	 * get all events from today
	 * @return
	 */
	public ArrayList<CalendarEntry> getTodayEntries()
	{
		return calendar.getTodayEntries();
	}
	public Calendar getCalendar()
	{
		return calendar;
	}
	/**
	 * update the data of a specific activity
	 * @param activity
	 */
	public void updateActivity(Activity activity)
	{

	}
}