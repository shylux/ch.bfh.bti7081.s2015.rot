package ch.bfh.bti7081.s2015.red.PatientApp;


import java.util.ArrayList;


import java.util.Calendar;
import java.util.Date;

import ch.bfh.bti7081.s2015.red.PatientApp.Db.MongoDbAdapter;
import ch.bfh.bti7081.s2015.red.PatientApp.Db.Persistable;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.Circle;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.GpsCoordinate;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.GpsActivity;

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
		
		ArrayList<Persistable> activities = new ArrayList<>();
		
		activities.add(new GpsActivity("Migros Einkaufen",
				"a bootle a day...", new Circle(new GpsCoordinate(46.965806,7.4638448)), new Date(), end));
		cal.setTime(new Date());
		cal.add(Calendar.HOUR_OF_DAY, 3);
		 end = cal.getTime();
		activities.add(new GpsActivity("Auswärts essen",
				"Eingliedern in die Gesellschaft", new Circle(new GpsCoordinate(46.9646601,7.459328)), new Date(), end));
		
		
		activities.add(new GpsActivity("Auswärts essen",
				"Eingliedern in die Gesellschaft", new Circle(new GpsCoordinate(46.9656559,7.4569998)), new Date(), end));
		cal.setTime(new Date());
		cal.add(Calendar.HOUR_OF_DAY, 24);
		Date start = cal.getTime();
		cal.add(Calendar.HOUR_OF_DAY,2);
		end = cal.getTime();
		activities.add(new GpsActivity("YB match besuchen",
				"Inkl. Alkfreies Bier", new Circle(new GpsCoordinate(46.9646601,7.459328)), end, end));
		
		adapter.erase();
		adapter.insertIntoDatabase(activities);

	}
}
