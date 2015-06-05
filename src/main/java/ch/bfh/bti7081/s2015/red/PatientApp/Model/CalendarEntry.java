package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import ch.bfh.bti7081.s2015.red.PatientApp.Db.Persistable;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.Gson;
import com.vaadin.ui.components.calendar.event.BasicEvent;

public abstract class CalendarEntry extends BasicEvent implements Persistable {
	
	public abstract String display();
	
	//protected Date endTime;
	//protected String shortName;
	/*protected String description;*/
	//protected Date startTime;

	public CalendarEntry(){}
	public CalendarEntry(String shortName,String description)
	{
		//this.shortName = shortName;
		this.setCaption(shortName);
		//this.description = description;
		this.setDescription(description);
	}
	public CalendarEntry(String shortName,String description,Date start, Date end)
	{
		this(shortName,description);
		this.setStart(start);
		this.setEnd(end);
		//this.startTime = start;
		//this.endTime = end;
	}
	public CalendarEntry(String id){this.id = id;}
	public abstract String getUrl();
	
	@Expose protected String id =""; //unique id, necessary for db storage
	/*
	 * class type, necessary for type specific search in the database
	 */
	@Expose private String type = this.getClass().toString(); 
	
	/**
	 * for testing only
	 * @return
	 */
	@Expose protected String display;
	
	/**
	 * for testing only 
	 */
	public abstract void setDisplay(String data);

	/*
	 * Getter's and Setters 
	 */
	public Date getStartTime() {
		return this.getStart();
	}
	
	public void setStartTime(Date startTime) {
		this.setStart(startTime);
	}


	public Date getEndTime() {
		return this.getEnd();
	}


	public void setEndTime(Date endTime) {
		this.setEnd(endTime);
	}


	public String getShortName() {
		return this.getCaption();
	}
	public void setShortName(String shortName) {
		//this.shortName = shortName;
		this.setCaption(shortName);
	}

/*
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	*/
	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
}
