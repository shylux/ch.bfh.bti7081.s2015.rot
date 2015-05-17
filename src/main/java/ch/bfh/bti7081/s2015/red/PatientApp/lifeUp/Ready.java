package ch.bfh.bti7081.s2015.red.PatientApp.lifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public class Ready extends NormalActivity {
  
	public Ready(Activity activity) {
		super(activity);
		super.setActivityState(this); 
	}

	public void handle() { 
		new Started(this, activity); 
	}

	public void debugName() {
		System.out.println("Ready");
	}	
	
}
