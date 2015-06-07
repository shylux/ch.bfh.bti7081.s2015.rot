package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;


public class MedicationEntry extends CalendarEntry{
	
	@Expose private String howMuchADay = "";
	@Expose private String howToTake = "";
	@Expose private ArrayList<String> times = new ArrayList<String>();
	
	public MedicationEntry(String name, String description, String howMuchADay, String howToTake, ArrayList<String> times) {
		this.shortName = name;
		this.description = description;
		this.howMuchADay = howMuchADay;
		this.howToTake = howToTake;
		this.times = times;
	}
	public MedicationEntry(String id){super(id);}
	public MedicationEntry(){}
	
	/*
	 * class type, necessary for type specific search in the database
	 */
	
	@Override
	public String display() {
		return display;
	
	}

	@Override
	public void setDisplay(String data) {
		display = data;
		
	}

	/*
	 * Getter / Setter 
	 */
	public String getName() {
		return shortName;
	}

	public void setName(String shortName) {
		this.shortName = shortName;
	}

	public String getHowMuchADay() {
		return howMuchADay;
	}

	public void setHowMuchADay(String howMuchADay) {
		this.howMuchADay = howMuchADay;
	}

	public String getHowToTake() {
		return howToTake;
	}

	public void setHowToTake(String howToTake) {
		this.howToTake = howToTake;
	}

	public ArrayList<String> getTimes() {
		return times;
	}

	public void setTimes(ArrayList<String> times) {
		this.times = times;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String getUrl() {
		// TODO Auto-generated method stub
		return "#!Medication/"+id;
	}
	
	
	

}
