package ch.bfh.bti7081.s2015.red.PatientApp.lifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public class Started extends NormalActivity {

	public Started(Activity activity) {
		this.activity = activity;
		setActivityState(this); 
	}
 
	@Override
	public void handle() {
		new Finished(activity); 
	}	 
	 
}
