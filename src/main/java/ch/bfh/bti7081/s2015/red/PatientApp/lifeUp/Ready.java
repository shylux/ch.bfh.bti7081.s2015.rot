package ch.bfh.bti7081.s2015.red.PatientApp.lifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public class Ready extends NormalActivity {
  
	public Ready(Activity activity) { 
		this.activity = activity;
		setActivityState(this);
	}	
	
	@Override
	public void handle() { 
		new Started(activity); 
	}	 
	
}
