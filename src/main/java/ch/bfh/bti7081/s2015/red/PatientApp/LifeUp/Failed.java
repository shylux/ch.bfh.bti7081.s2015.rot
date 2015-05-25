package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public class Failed extends TimeActivity {

	volatile TimeActivityManager manager;
	
	public Failed(Activity activity) { 
		System.out.println("Sie haben versagt!, sie oberlusche");
		this.activity = activity;
		this.activity.setGivenPoints(FAILED);
		manager = TimeActivityManager.getInstance();
		manager.chooseActivity(activity);
		manager.setActivityState(this);	 
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
