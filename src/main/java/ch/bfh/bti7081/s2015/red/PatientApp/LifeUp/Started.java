<<<<<<< HEAD
package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

/**
 * The state Ready is a NormalActivity state. 
 * Every not time relevant progress which has been started goes here. 
 * @author Stefan Tanner
 *
 */		
public class Started extends NormalActivity {	
	
	public Started(ActivityState lastState, Activity activity) {
		this.activity = activity;
		setActivityState(this); 
		storeState();
	}
 
	public Started() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle() {
		new Finished(this, activity); 
	}	 
	 
}
=======
package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public class Started extends NormalActivity {

	public Started(ActivityState lastState, Activity activity) {
		this.activity = activity;
		setActivityState(this); 
		storeState();
	}
 
	public Started() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle() {
		new Finished(this, activity); 
	}	 
	 
}
>>>>>>> ea0426ddbc9228ec23d9b4160cd723cd4c843ede
