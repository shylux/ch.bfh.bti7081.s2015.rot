package ch.bfh.bti7081.s2015.red.PatientApp.lifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public abstract class ActivityState {
	
	protected Activity activity;
	
	protected  void setActivityState(ActivityState activityState) { 
		activity.setActivityState(activityState);
	}
	
	public String getStateName() {
		return this.getClass().getName();
	}
	public String getStateShortName()
	{
		return this.getClass().getSimpleName();
	}
	
	protected abstract void OnEnter();
	protected abstract void OnExit();
	public abstract void handle(); 
	 
}