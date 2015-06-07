package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public class Failed extends TimeActivity {

	// Empty Constructor for GSON-Libary for deserialisation
	public Failed() {
		// nothing to be done
	}		
	
	volatile TimeActivityManager manager;
	
	public Failed(Activity activity) { 
		this.activity = activity;
		this.activity.setGivenPoints(FAILED);
		manager = TimeActivityManager.getInstance();
		manager.chooseActivity(activity);
		manager.setActivityState(this);	 
		setActivityState(this);
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

	@Override
	public void handle() {
		new Closed(activity);
	}

}
