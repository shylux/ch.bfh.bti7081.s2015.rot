package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public class Ready extends NormalActivity {
  
	public Ready(Activity activity) { 
		this.activity = activity;
		setActivityState(this);
	}	
	
	@Override
	public void handle() { 
		new Started(activity); 
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
