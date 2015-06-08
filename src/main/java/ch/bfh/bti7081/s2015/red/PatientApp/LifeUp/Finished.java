package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

/**
 * The state Finished is a NormalActivity state. 
 * Every not time relevant progress goes to this. 
 * @author Stefan Tanner
 *
 */	
public class Finished extends NormalActivity {		
	
	// Empty Constructor for GSON-Libary for deserialisation
	public Finished() {
		// nothing to be done
	}	


	public Finished(ActivityState lastState, Activity activity) {
		this.activity = activity;
		setActivityState(this); 
		storeState();
		new Closed(activity);
	}
 
	@Override
	public void handle() {

	} 
  
}
