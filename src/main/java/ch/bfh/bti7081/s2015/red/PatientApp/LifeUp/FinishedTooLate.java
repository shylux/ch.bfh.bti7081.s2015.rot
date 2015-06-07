package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public class FinishedTooLate extends TimeActivity {
	
	// Empty Constructor for GSON-Libary for deserialisation
	public FinishedTooLate() {
		// nothing to be done
	}	
		
	
	public FinishedTooLate(Activity activity) { 
		this.activity = activity;
		this.activity.setGivenPoints(FINISHED_TOO_LATE);
		setActivityState(this);
		storeState();
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
