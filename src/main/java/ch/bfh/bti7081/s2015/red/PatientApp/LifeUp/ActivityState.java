package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

import com.google.gson.annotations.Expose;

import ch.bfh.bti7081.s2015.red.PatientApp.Db.MongoDbAdapter;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

/**
 * The ActivityState ist the main state  
 * and will be stored in the Activity.
 * Specific States inherits from here.
 * @author Stefan Tanner
 *
 */	
public abstract class ActivityState {
	
	@Expose private String type = this.getClass().toString();
	protected Activity activity;
	
	/**
	 * Set the type field of the ActivityState, so the DB-Adapter can serialize/deserialize it
	 */	
	protected void storeState() {
		MongoDbAdapter adapter = new MongoDbAdapter();
		
		if(activity.getId() == null || activity.getId().equals(""))
		{
			adapter.insertIntoDatabase(activity);
		}
		else
		{
			adapter.updateEntry(activity);
		}
	}
	
	/**
	 * Sets the referencing ActivityState to it's activity
	 *   
	 * @param	ActivityState	the calling ActivityState - in most case, use 'this'
	 * @see		Activity
	 */		
	protected  void setActivityState(ActivityState activityState) { 
		activity.setActivityState(activityState);
	}
	
	/**
	 * Sets the referencing Activity to it's state
	 *   
	 * @param	Activity	the calling Activity - in most case, use 'this'
	 * @see		Activity
	 */	
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	
	/**
	 * Returns the name of the current state as String.
	 *  
	 * @return	String	the current state
	 * @see		Activity
	 */	
	public String getStateName() {
		String[] count = this.getClass().getName().split("\\.");
		return this.getClass().getName().split("\\.")[count.length - 1];
	}
	
	/**
	 * Returns the short name of the current state as String.
	 *  
	 * @return	String	the current state in short form
	 * @see		Activity
	 */	
	public String getStateShortName()
	{
		return this.getClass().getSimpleName();
	}
	
	protected abstract void OnEnter();
	protected abstract void OnExit();
	
	/**
	 * Does force the current state to change to the next state.
	 */	
	public abstract void handle(); 
	 
}
