package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.Db.MongoDbAdapter;
import ch.bfh.bti7081.s2015.red.PatientApp.DbInitializer;
import com.google.gson.Gson;

import ch.bfh.bti7081.s2015.red.PatientApp.Db.Persistable;
import com.ibm.icu.impl.duration.PeriodFormatterService;

public class Emergency implements Persistable{
	private ArrayList<EmergencyStep> steps = new ArrayList<EmergencyStep>();
	
	private String id; //unique id, necessary for db storage
	/*
	 * class type, necessary for type specific serach in the database
	 */
	private String type = this.getClass().toString(); 

	public Emergency() {
        DbInitializer.restore();
        MongoDbAdapter dbAdapter = new MongoDbAdapter();
        steps = dbAdapter.getSpecificCollection(EmergencyStep.class);
	}
	
	public ArrayList<EmergencyStep> getSteps() {
		return steps;
	}

	public void setSteps(ArrayList<EmergencyStep> steps) {
		this.steps = steps;
	}

	public String serialize() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	public String getId() {
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	
}
