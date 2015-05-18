import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.GpsActivity;
import ch.bfh.bti7081.s2015.red.PatientApp.lifeUp.Ready;

public class statePatternTester<PhotoActivity> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Activity activity = new GpsActivity();
		activity.setActivityState(new Ready(activity)); 
		activity.displayCurrentState();
		activity.nextState(); 
		activity.displayCurrentState();
		activity.nextState(); 
		activity.displayCurrentState();
		activity.nextState(); 
		activity.displayCurrentState();
		activity.nextState(); 
		activity.displayCurrentState(); 
		activity.nextState(); 
		activity.displayCurrentState(); 
	}

}
