package ch.bfh.bti7081.s2015.red.PatientApp.lifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public class FinishedTooLate extends TimeActivity {

	public FinishedTooLate(Activity activity) { 
		this.activity = activity;
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
		// TODO Auto-generated method stub
		new Closed(activity);
	}

}
