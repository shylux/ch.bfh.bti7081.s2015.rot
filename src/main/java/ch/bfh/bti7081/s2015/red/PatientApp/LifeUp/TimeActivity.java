package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

/**
 * The state TimeActivity more specific state than ActivityState. 
 * Every progress which is time relevant goes here. 
 * @author Stefan Tanner
 *
 */	
public abstract class TimeActivity extends ActivityState { 

	protected final int FINISHED_IN_TIME = 100;
	protected final int FINISHED_TOO_LATE = 70;
	protected final int FAILED = 0;
}
