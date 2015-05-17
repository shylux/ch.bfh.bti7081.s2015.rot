package ch.bfh.bti7081.s2015.red.PatientApp.lifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public class Finished extends NormalActivity {
	
	public Finished(ActivityState lastState, Activity activity) {
		super(activity);
		super.setActivityState(this); 
		OnEnter(lastState);
	}

	public void handle() {
		new Closed(this, activity); 
	}
	
	public void debugName() {
		System.out.println("Finished");
	}
	
}
