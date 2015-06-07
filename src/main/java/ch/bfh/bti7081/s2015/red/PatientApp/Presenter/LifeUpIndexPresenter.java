package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;


import java.util.ArrayList;
import java.util.Date;

import ch.bfh.bti7081.s2015.red.PatientApp.DbInitializer;
import ch.bfh.bti7081.s2015.red.PatientApp.Db.MongoDbAdapter;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.TimeActivityManager;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.TimeActivityReady;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.GpsActivity;
import ch.bfh.bti7081.s2015.red.PatientApp.View.View;

public class LifeUpIndexPresenter extends BasePresenter<Activity>{

	private ArrayList<GpsActivity> activities;
	public LifeUpIndexPresenter(View view) {
		super(view);

		/*
		4d14df7... implemented restoreView, added threadStop for reminder
		
		MongoDbAdapter adapter = new MongoDbAdapter();
		activities = adapter.getSpecificCollection(GpsActivity.class);
		
		TimeActivityManager manager = TimeActivityManager.getInstance();
		long SECONDS_IN_MS = 1000;
		Date now = new Date();  
		
		for (int i = 0; i < activities.size(); i++) {
			GpsActivity currentActivity = activities.get(i);
			currentActivity.setSoftTimeLimit(new Date(now.getTime() + (20 * SECONDS_IN_MS)));
			currentActivity.setHardTimeLimit(new Date(now.getTime() + (50 * SECONDS_IN_MS)));
			manager.addActivity(activities.get(i));
			new TimeActivityReady(activities.get(i));
		}			
			
		view.update(activities);*/
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
