package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import java.util.Date;

import ch.bfh.bti7081.s2015.red.PatientApp.Db.Persistable;

import com.google.gson.Gson;

public abstract class CalendarEntry implements Persistable{
	
	public abstract String display();
	
	protected Date endTime;
	protected String shortName;
	protected String description;
	protected Date startTime;

	private String id =""; //unique id, necessary for db storage
	/*
	 * class type, necessary for type specific search in the database
	 */
	private String type = this.getClass().toString(); 
	
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
		Gson gson = new Gson();
		return gson.toJson(this);
 
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
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}

}
