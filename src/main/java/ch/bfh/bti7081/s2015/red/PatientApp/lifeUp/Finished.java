package ch.bfh.bti7081.s2015.red.PatientApp.lifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public class Finished extends NormalActivity {
	
	public Finished(ActivityState lastState, Activity activity) {
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
		new Closed(this, activity); 
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
