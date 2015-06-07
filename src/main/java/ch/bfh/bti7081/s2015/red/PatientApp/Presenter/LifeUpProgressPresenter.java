package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;

import java.util.ArrayList;
import java.util.Date;

import ch.bfh.bti7081.s2015.red.PatientApp.Db.MongoDbAdapter;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.TimeActivityManager;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.TimeActivityReady;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.GpsActivity;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.LifeUpProgressModel;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.StartPageModel;
import ch.bfh.bti7081.s2015.red.PatientApp.View.View;

public class LifeUpProgressPresenter extends BasePresenter<Activity>{

	private LifeUpProgressModel modelLifeUpProgress;
	private ArrayList<Activity> activities;

	public LifeUpProgressPresenter(View view) {
		super(view);

		System.out.println("ENETERING LIFEUPPROGRESS PRESENTER");
		
		MongoDbAdapter adapter = new MongoDbAdapter();
		activities = adapter.getSpecificCollection(GpsActivity.class);
		
  
		long SECONDS_IN_MS = 1000;
		Date now = new Date();  
		
		for (int i = 0; i < activities.size(); i++) {
			Activity currentActivity = activities.get(i); 
			System.out.println("Activitystatus restored Progress:" + currentActivity);
		}	 		
		 
		// TODO Auto-generated constructor stub
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
