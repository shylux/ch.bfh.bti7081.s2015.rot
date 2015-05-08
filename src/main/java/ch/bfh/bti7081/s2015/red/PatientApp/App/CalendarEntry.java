package ch.bfh.bti7081.s2015.red.PatientApp.App;

import java.util.Date;

import com.google.gson.Gson;

public abstract class CalendarEntry implements Persistable{
	
	public abstract String display();
	
	protected Date endTime;
	protected String shortName;
	protected String description;
	protected Date startTime;
	
	
	/**
	 * for testing only
	 * @return
	 */
	protected String display;
	
	/**
	 * for testing only 
	 */
	public abstract void setDisplay(String data);
	

	public String serialize() {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	
	public void deserialize(String json) {

	}
	
	/*
	 * Getter's and Setters 
	 */
	public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	public Date getEndTime() {
		return endTime;
	}


	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
}
