package ch.bfh.bti7081.s2015.red.PatientApp.Test;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.GpsActivity;
import ch.bfh.bti7081.s2015.red.PatientApp.lifeUp.Ready;
import org.junit.Assert;
import org.junit.Test;


public class TestStatePattern {

	@Test
	public void testStateEventHandling() {
		
		Activity activity = new GpsActivity();
		activity.setActivityState(new Ready(activity)); 
		Assert.assertEquals("ch.bfh.bti7081.s2015.red.PatientApp.lifeUp.Ready", activity.getStateName());
		activity.nextState(); 
		Assert.assertEquals("ch.bfh.bti7081.s2015.red.PatientApp.lifeUp.Started", activity.getStateName());
		activity.nextState(); 
		Assert.assertEquals("ch.bfh.bti7081.s2015.red.PatientApp.lifeUp.Finished", activity.getStateName());
		activity.nextState(); 
		Assert.assertEquals("ch.bfh.bti7081.s2015.red.PatientApp.lifeUp.Closed", activity.getStateName());
		activity.nextState(); 
		Assert.assertEquals("ch.bfh.bti7081.s2015.red.PatientApp.lifeUp.Closed", activity.getStateName());
		
	}
	
}
