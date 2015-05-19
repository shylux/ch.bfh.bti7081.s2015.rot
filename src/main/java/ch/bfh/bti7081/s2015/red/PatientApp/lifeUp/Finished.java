package ch.bfh.bti7081.s2015.red.PatientApp.lifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public class Finished extends NormalActivity {
	
	public Finished(ActivityState lastState, Activity activity) {
		this.activity = activity;
		setActivityState(this); 
	}
 
	@Override
	public void handle() {
		new Closed(this, activity); 
	} 
  
}
