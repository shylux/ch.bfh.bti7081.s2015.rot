package ch.bfh.bti7081.s2015.red.PatientApp.lifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;
 
public class Closed extends ActivityState {

	public Closed(ActivityState lastState, Activity activity) {
		super.activity = activity;
		super.setActivityState(this); 
		OnEnter(lastState);
	}
	
	@Override
	protected void OnEnter(ActivityState lastState) {
		lastState = null; 
	}
	
	@Override
	public void handle() {
		// TODO Auto-generated method stub
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
