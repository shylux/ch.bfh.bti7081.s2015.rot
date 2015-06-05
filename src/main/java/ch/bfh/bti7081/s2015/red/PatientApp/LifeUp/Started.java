package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public class Started extends NormalActivity {

	public Started(Activity activity) {
		this.activity = activity;
		setActivityState(this); 
	}
 
	public Started() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle() {
		new Finished(activity); 
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
