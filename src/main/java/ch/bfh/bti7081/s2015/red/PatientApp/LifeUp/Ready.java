package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public class Ready extends NormalActivity {
  
	public Ready(Activity activity) { 
		this.activity = activity;
		setActivityState(this);
		storeState();
	}	
	
	public Ready() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle() { 
		new Started(this, activity); 
	}	 
	
}
