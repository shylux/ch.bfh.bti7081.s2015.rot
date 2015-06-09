package ch.bfh.bti7081.s2015.red.PatientApp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import ch.bfh.bti7081.s2015.red.PatientApp.Db.MongoDbAdapter;
import ch.bfh.bti7081.s2015.red.PatientApp.Db.Persistable;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.Circle;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.GpsCoordinate;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.Ready;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Contact;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.EmergencyStep;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.GpsActivity;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.MedicationEntry;



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

		GpsActivity act0 = new  GpsActivity("Migros Einkaufen",
				"a bootle a day...", new Circle(new GpsCoordinate(46.965806,7.4638448)), new Date(), end);
		act0.setActivityState(new Ready());
		dbentrys.add(act0);
		cal.setTime(new Date());
		cal.add(Calendar.MINUTE, 50);
		end = cal.getTime();
		 
		GpsActivity act1 = new GpsActivity("Auswärts essen",
				"Eingliedern in die Gesellschaft", new Circle(new GpsCoordinate(46.9646601,7.459328)), new Date(), end);
		act1.setActivityState(new Ready());
		dbentrys.add(act1);

		GpsActivity act2 =  new GpsActivity("Auswärts essen2",
				"Eingliedern in die Gesellschaft", new Circle(new GpsCoordinate(46.9656559,7.4569998)), new Date(), end);
		
		act2.setActivityState(new Ready());		
		dbentrys.add(act2);
		cal.setTime(new Date());
		cal.add(Calendar.HOUR_OF_DAY, 24);
		Date start = cal.getTime();
		cal.add(Calendar.HOUR_OF_DAY,2);
		end = cal.getTime();
		
		GpsActivity act3 = new GpsActivity("YB match besuchen",
				"Inkl. Alkfreies Bier", new Circle(new GpsCoordinate(46.9646601,7.459328)), end, end);
		act3.setActivityState(new Ready());
		dbentrys.add(act3);


		ArrayList<Persistable> activities = new ArrayList<>();
		ArrayList<Persistable> medications = new ArrayList<>();

		// Taking times for the first medication
		ArrayList<String> times1 = new ArrayList<String>();
		times1.add("21:00 Uhr");

		// Taking times for the second medication
		ArrayList<String> times2 = new ArrayList<String>();
		times2.add("09:00 Uhr");

		// Taking times for the third medication
		ArrayList<String> times3 = new ArrayList<String>();
		times3.add("08:00 Uhr");
		times3.add("12:00 Uhr");
		times3.add("15:00 Uhr");
		times3.add("19:00 Uhr");

		medications.add(new MedicationEntry("Sanalepsi N", "Schlafmittel und Antiallergikum", "Einmal am Tag vor dem Schlafen, mehrmals am Tag gegen ", "In den Mund tröpfeln lassen und schlucken", times1));
		medications.add(new MedicationEntry("Methadon", "Ersatzdroge für Heroin", "Pro Tag bis zu 40mg", "Oral einfügen", times2));
		medications.add(new MedicationEntry("Ipoprofen 600mg", "Schmerzmittel", "2,4g Täglich", "Tablette schlucken", times3));

		
		/* EmergencySteps */
		dbentrys.add(new EmergencyStep("Take a deep breath."));
		dbentrys.add(new EmergencyStep("Yell at Neighbour."));
		dbentrys.add(new EmergencyStep("Call your representative.",
				new Contact("Bin Laden", "+23 323 56 34")));
		dbentrys.add(new EmergencyStep("Call Yoda",
				new Contact("Minch Yoda", "+12 345 67 89")));
		
		adapter.erase();
		adapter.insertIntoDatabase(dbentrys);
		adapter.insertIntoDatabase(activities);
		adapter.insertIntoDatabase(medications);

	}
}