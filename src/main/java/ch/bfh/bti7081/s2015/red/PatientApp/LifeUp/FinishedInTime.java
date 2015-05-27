package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public class FinishedInTime extends TimeActivity {

	public FinishedInTime(Activity activity) { 
		this.activity = activity;
		this.activity.setGivenPoints(FINISHED_IN_TIME);
		setActivityState(this);
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
