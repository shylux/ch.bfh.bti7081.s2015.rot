package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import java.util.Date;

import ch.bfh.bti7081.s2015.red.PatientApp.lifeUp.ActivityState;

public abstract class Activity extends CalendarEntry {
	protected ActivityState activityState;
	protected Date softTimeLimit;
	protected Date hardTimeLimit;
	int givenPoints  = 0;
	boolean done;

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
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
}
