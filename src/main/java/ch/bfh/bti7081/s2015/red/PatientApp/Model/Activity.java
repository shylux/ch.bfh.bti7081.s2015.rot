package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import java.util.Date;

import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.ActivityState;

public abstract class Activity extends CalendarEntry {
	protected ActivityState activityState;
	protected Date softTimeLimit;
	protected Date hardTimeLimit;
	private int givenPoints  = 0;

	public Activity(){}
	public Activity(String id){super(id);}
	public Activity(String shortName,String description)
	{
		super(shortName,description);
	}
	public Activity(String shortName,String description,Date start, Date end)
	{
		super(shortName,description,start,end);
	}
	
	public abstract boolean checkSuccess();

	///////// STATE PATTERN
	
	public String getStateName() {
		return activityState.getStateName();
	}
	
	// Clickevent or whatever
	public void nextState() {
		activityState.handle();
	}
	
	public void setActivityState(ActivityState nextActivityState) {
		activityState = nextActivityState;
	}
	
	///////// STATE PATTERN
	
	public Date getSoftTimeLimit() {
		return softTimeLimit;
	}

	public void setSoftTimeLimit(Date softTimeLimit) {
		this.softTimeLimit = softTimeLimit;
	}

	public Date getHardTimeLimit() {
		return hardTimeLimit;
	}

	public void setHardTimeLimit(Date hardTimeLimit) {
		this.hardTimeLimit = hardTimeLimit;
	}

	public int getGivenPoints() {
		return givenPoints;
	}

	public void setGivenPoints(int givenPoints) {
		this.givenPoints = givenPoints;
	}
	
	
	public boolean isDone() {
		return false;
	}
}
