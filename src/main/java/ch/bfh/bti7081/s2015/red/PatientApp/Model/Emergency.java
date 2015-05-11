package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import java.util.ArrayList;

import com.google.gson.Gson;

import ch.bfh.bti7081.s2015.red.PatientApp.Db.Persistable;

public class Emergency implements Persistable{
	private ArrayList<EmergencyStep> steps = new ArrayList<EmergencyStep>();
	
	private String id; //unique id, necessary for db storage
	/*
	 * class type, necessary for type specific serach in the database
	 */
	private String type = this.getClass().toString(); 

	public Emergency() {
		steps.add(new EmergencyStep("Take a deep breath."));
		steps.add(new EmergencyStep("Yell at Neighbour."));
		steps.add(new EmergencyStep("Call your representative.",
									new Contact("Bin Laden", "+23 323 56 34")));
		steps.add(new EmergencyStep("Call Yoda",
									new Contact("Minch Yoda", "+12 345 67 89")));
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
