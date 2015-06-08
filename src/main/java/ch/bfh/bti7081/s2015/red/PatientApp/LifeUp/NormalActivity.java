package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp; 

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

/**
 * The state NormalActivity more specific state than ActivityState. 
 * Every progress which is not time relevant goes here. 
 * @author Stefan Tanner
 *
 */	
public abstract class NormalActivity extends ActivityState {		
	
	@Override
	protected void OnExit() {
		// TODO Auto-generated method stub	
	}

	@Override
	protected void OnEnter() {
		// TODO Auto-generated method stub
	}		
}
