package ch.bfh.bti7081.s2015.red.PatientApp.lifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public class Started extends NormalActivity {

	public Started(ActivityState lastState, Activity activity) {
		super(activity);
		super.setActivityState(this); 
		OnEnter(lastState);
	}

	@Override
	protected void OnEnter(ActivityState lastState) {
		lastState = null; 
	}
	
	@Override
	public void handle() {
		new Finished(this, activity); 
	}	

	@Override
	protected void OnExit() {
		// TODO Auto-generated method stub
	}	
	
	@Override
	public void debugName() {
		System.out.println(this.getClass().getName());
	}
}
