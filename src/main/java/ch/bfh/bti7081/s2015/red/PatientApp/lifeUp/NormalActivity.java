package ch.bfh.bti7081.s2015.red.PatientApp.lifeUp; 

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public abstract class NormalActivity extends ActivityState {
  
	NormalActivity(Activity activity) {
		super.activity = activity; 
	}

	protected void setActivityState(ActivityState activityState) {
		super.setActivityState(activityState);
	}
	 
}
