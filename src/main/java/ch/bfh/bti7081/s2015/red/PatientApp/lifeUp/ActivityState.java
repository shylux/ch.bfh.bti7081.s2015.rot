package ch.bfh.bti7081.s2015.red.PatientApp.lifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public abstract class ActivityState {
	
	protected Activity activity;
	
	protected  void setActivityState(ActivityState activityState) { 
		activity.setActivityState(activityState);
	}
	
	protected void OnEnter(ActivityState lastState) {
		lastState = null;
		System.out.println("Status entfernt.");
	}
	
	protected void OnExit() {
		
	}
	
	public void handle() {
		
	}

	public void debugName() {
		 
	}
	 
}
