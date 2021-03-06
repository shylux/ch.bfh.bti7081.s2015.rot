package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;

import java.util.ArrayList;
import java.util.Date;

import ch.bfh.bti7081.s2015.red.PatientApp.DbInitializer;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.TimeActivityManager;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.TimeActivityReady;
import ch.bfh.bti7081.s2015.red.PatientApp.App.PatientApp;
import ch.bfh.bti7081.s2015.red.PatientApp.Db.MongoDbAdapter;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.GpsActivity;
import ch.bfh.bti7081.s2015.red.PatientApp.View.View;



public class LifeUpDetailPreseter extends BasePresenter<Activity>{
	private ArrayList<Activity> activities;
	
	public LifeUpDetailPreseter(View view) {
		super(view);

        ArrayList<Activity> activities = PatientApp.getInstance().getCalendar().getAllActivites();
		TimeActivityManager manager = TimeActivityManager.getInstance();
		
		long SECONDS_IN_MS = 1000;
		Date now = new Date();  
		
		for (int i = 0; i < activities.size(); i++) {
			Activity currentActivity = activities.get(i);
			currentActivity.setSoftTimeLimit(new Date(now.getTime() + (40 * SECONDS_IN_MS)));
			currentActivity.setHardTimeLimit(new Date(now.getTime() + (60 * SECONDS_IN_MS)));
			manager.addActivity(activities.get(i));
			new TimeActivityReady(activities.get(i));	
		}	 
		view.update(activities);
	}


	@Override
	public void buttonClick(String property, Activity data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buttonClick(String property, ArrayList<Activity> data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void triggerEvent(String event, Activity data) {
		// TODO Auto-generated method stub
		
	}

}
