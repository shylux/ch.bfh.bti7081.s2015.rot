package ch.bfh.bti7081.s2015.red.PatientApp.lifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public class Started extends NormalActivity {

	public Started(ActivityState lastState, Activity activity) {
		super(activity);
		super.setActivityState(this); 
		OnEnter(lastState);
	}
  
	public void handle() {
		new Finished(this, activity); 
	}	

	public void debugName() {
		System.out.println("Started");
	}
	
}
