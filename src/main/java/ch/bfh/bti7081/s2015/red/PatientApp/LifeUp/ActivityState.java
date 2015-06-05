package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

import com.google.gson.annotations.Expose;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public abstract class ActivityState {
	

	protected Activity activity;
	
	protected  void setActivityState(ActivityState activityState) { 
		activity.setActivityState(activityState);
	}
	
	public String getStateName() {
		String[] count = this.getClass().getName().split("\\.");
		return this.getClass().getName().split("\\.")[count.length - 1];
	}
	public String getStateShortName()
	{
		return this.getClass().getSimpleName();
	}
	
	protected abstract void OnEnter();
	protected abstract void OnExit();
	public abstract void handle(); 
	 
}
