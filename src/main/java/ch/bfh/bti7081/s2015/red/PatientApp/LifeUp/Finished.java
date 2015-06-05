package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public class Finished extends NormalActivity {
	
	// Empty Constructor for GSON-Libary for deserialisation
	public Finished() {
		// nothing to be done
	}	
	
	public Finished(Activity activity) {
		this.activity = activity;
		this.activity.setGivenPoints(FINISHED);
		setActivityState(this); 
		storeState();
	}
 
	@Override
	public void handle() {
		new Closed(activity); 
	}

	@Override
	protected void OnEnter() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void OnExit() {
		// TODO Auto-generated method stub
	} 
  
}
