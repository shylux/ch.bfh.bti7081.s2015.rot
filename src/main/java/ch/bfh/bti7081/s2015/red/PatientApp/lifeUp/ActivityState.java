package ch.bfh.bti7081.s2015.red.PatientApp.lifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public abstract class ActivityState {
	
	protected Activity activity;
	
	protected  void setActivityState(ActivityState activityState) { 
		activity.setActivityState(activityState);
	}
	
	protected abstract void OnEnter(ActivityState lastState);
	protected abstract void OnExit();
	public abstract void handle();
	public abstract void debugName();
	 
}
