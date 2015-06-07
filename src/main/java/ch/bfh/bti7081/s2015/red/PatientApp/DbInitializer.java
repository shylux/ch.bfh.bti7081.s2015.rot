package ch.bfh.bti7081.s2015.red.PatientApp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import ch.bfh.bti7081.s2015.red.PatientApp.Db.MongoDbAdapter;
import ch.bfh.bti7081.s2015.red.PatientApp.Db.Persistable;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.Circle;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.GpsCoordinate;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Contact;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.EmergencyStep;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.GpsActivity;

/**
 * A class that insert data into database. Used in development.
 * This resets/restores the database to make sure everyone has the same state.
 * @author James
 */
public class DbInitializer 
{
	/*
	 * setup up db data here (for testing only)
	 */
	public static void restore()
	{

		
		Calendar cal = Calendar.getInstance(); 
	    cal.setTime(new Date()); 
	    cal.add(Calendar.HOUR_OF_DAY, 5); 
	    Date end = cal.getTime(); 
		
		
		MongoDbAdapter adapter = new MongoDbAdapter();
		
		ArrayList<Persistable> dbentrys = new ArrayList<>();

		dbentrys.add(new GpsActivity("Migros Einkaufen",
				"a bootle a day...", new Circle(new GpsCoordinate(46.965806,7.4638448)), new Date(), end));
		cal.setTime(new Date());
		cal.add(Calendar.MINUTE, 50);
		end = cal.getTime();
		 
		
		dbentrys.add(new GpsActivity("Auswärts essen",
				"Eingliedern in die Gesellschaft", new Circle(new GpsCoordinate(46.9646601,7.459328)), new Date(), end));


		dbentrys.add(new GpsActivity("Auswärts essen",
				"Eingliedern in die Gesellschaft", new Circle(new GpsCoordinate(46.9656559,7.4569998)), new Date(), end));
		cal.setTime(new Date());
		cal.add(Calendar.HOUR_OF_DAY, 24);
		Date start = cal.getTime();
		cal.add(Calendar.HOUR_OF_DAY,2);
		end = cal.getTime();
		dbentrys.add(new GpsActivity("YB match besuchen",
				"Inkl. Alkfreies Bier", new Circle(new GpsCoordinate(46.9646601,7.459328)), end, end));

		/* EmergencySteps */
		dbentrys.add(new EmergencyStep("Take a deep breath."));
		dbentrys.add(new EmergencyStep("Yell at Neighbour."));
		dbentrys.add(new EmergencyStep("Call your representative.",
				new Contact("Bin Laden", "+23 323 56 34")));
		dbentrys.add(new EmergencyStep("Call Yoda",
				new Contact("Minch Yoda", "+12 345 67 89")));
		
		adapter.erase();
		adapter.insertIntoDatabase(dbentrys);
	}
}
