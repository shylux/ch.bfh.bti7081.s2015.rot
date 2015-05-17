package ch.bfh.bti7081.s2015.red.PatientApp.lifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;
 
public class Closed extends ActivityState {

	public Closed(ActivityState lastState, Activity activity) {
		super.activity = activity;
		super.setActivityState(this); 
		OnEnter(lastState);
	}
	
	public void debugName() {
		System.out.println("Closed");
	}	
	
}
