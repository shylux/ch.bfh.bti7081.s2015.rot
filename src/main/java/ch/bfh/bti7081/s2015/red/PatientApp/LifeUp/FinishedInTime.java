package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

/**
 * The state FinishedInTime is a TimeActivity state. 
 * Every progress which is done before the soft time limit goes here. 
 * @author Stefan Tanner
 *
 */		
public class FinishedInTime extends TimeActivity {
	
	// Empty Constructor for GSON-Libary for deserialisation
	public FinishedInTime() {
		// nothing to be done
	}	
	
	public FinishedInTime(Activity activity) { 
		this.activity = activity;
		this.activity.setGivenPoints(FINISHED_IN_TIME);
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
