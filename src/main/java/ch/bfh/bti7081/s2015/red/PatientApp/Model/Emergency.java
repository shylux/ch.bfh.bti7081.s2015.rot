package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import ch.bfh.bti7081.s2015.red.PatientApp.Db.MongoDbAdapter;
import ch.bfh.bti7081.s2015.red.PatientApp.Db.Persistable;
import ch.bfh.bti7081.s2015.red.PatientApp.DbInitializer;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;

/**
 * An emergency is when a patient fears a relapse.
 * This class holds all steps to prevent that.
 */
public class Emergency implements Persistable{
	private ArrayList<EmergencyStep> steps = new ArrayList<EmergencyStep>();
	
	@Expose private String id; //unique id, necessary for db storage
	/*
	 * class type, necessary for type specific serach in the database
	 */
	@Expose private String type = this.getClass().toString(); 

	public Emergency() {
        
        MongoDbAdapter dbAdapter = new MongoDbAdapter();
        steps = dbAdapter.getSpecificCollection(EmergencyStep.class);
	}
	
	public ArrayList<EmergencyStep> getSteps() {
		return steps;
	}

	public void setSteps(ArrayList<EmergencyStep> steps) {
		this.steps = steps;
	}

	public String getId() {
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	
}
