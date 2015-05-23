package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import ch.bfh.bti7081.s2015.red.PatientApp.DbInitializer;
import ch.bfh.bti7081.s2015.red.PatientApp.Db.MongoDbAdapter;
import ch.bfh.bti7081.s2015.red.PatientApp.Db.Persistable;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.GpsActivity;
import ch.bfh.bti7081.s2015.red.PatientApp.View.View;
import ch.bfh.bti7081.s2015.red.PatientApp.lifeUp.TimeActivityManager;
import ch.bfh.bti7081.s2015.red.PatientApp.lifeUp.TimeActivityReady;

public class LifeUpIndexPresenter extends BasePresenter<Activity>{

	private ArrayList<GpsActivity> activities;
	public LifeUpIndexPresenter(View view) {
		super(view);
		DbInitializer.restore();
		MongoDbAdapter adapter = new MongoDbAdapter();
		activities = adapter.getSpecificCollection(GpsActivity.class);
		
		TimeActivityManager manager = TimeActivityManager.getInstance();
		long SECONDS_IN_MS = 1000;
		Date now = new Date();  
		
		for (int i = 0; i < activities.size(); i++) {
			GpsActivity currentActivity = activities.get(i);
			currentActivity.setSoftTimeLimit(new Date(now.getTime() + (10 * SECONDS_IN_MS)));
			currentActivity.setHardTimeLimit(new Date(now.getTime() + (180 * SECONDS_IN_MS)));
			manager.addActivity(activities.get(i));
			new TimeActivityReady(activities.get(i));	
			System.out.println("Hinzüfgen Activity");
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
