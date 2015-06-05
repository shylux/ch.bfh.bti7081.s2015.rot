package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

import java.util.Date;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public class InProgress extends TimeActivity { 
	
	// Empty Constructor for GSON-Libary for deserialisation
	public InProgress() {
		// nothing to be done
	}		
	
	volatile TimeActivityManager manager;
	
	public InProgress(Activity activity) {  
		this.activity = activity;  
		manager = TimeActivityManager.getInstance();
		manager.chooseActivity(activity);
		manager.setActivityState(this);	 
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
		Date now = new Date();
		int softTimeLimitRest = (int) ((activity.getSoftTimeLimit().getTime()-now.getTime()) / 1000);
		int hardTimeLimitRest = (int) ((activity.getHardTimeLimit().getTime()-now.getTime()) / 1000); 
		
		if ( softTimeLimitRest > 0 ) {
			System.out.println("-> FinishedInTime");
			new FinishedInTime(activity); 
		}
		else {
			if ( hardTimeLimitRest > 0 ) {
				System.out.println("-> FinishedTooLate");
				new FinishedTooLate(activity); 
			}
			else {
				new Failed(activity); 
			}
		}
		 
	}

}
