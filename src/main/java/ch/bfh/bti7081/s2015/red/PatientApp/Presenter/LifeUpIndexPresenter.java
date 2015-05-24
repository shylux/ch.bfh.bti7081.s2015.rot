package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;

import ch.bfh.bti7081.s2015.red.PatientApp.Db.MongoDbAdapter;
import ch.bfh.bti7081.s2015.red.PatientApp.DbInitializer;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.GpsActivity;
import ch.bfh.bti7081.s2015.red.PatientApp.View.View;

import java.util.ArrayList;

public class LifeUpIndexPresenter extends BasePresenter<Activity>{

	private ArrayList<GpsActivity> activities;
	public LifeUpIndexPresenter(View view) {
		super(view);
		DbInitializer.restore();
		MongoDbAdapter adapter = new MongoDbAdapter();
		activities = adapter.getSpecificCollection(GpsActivity.class);
		
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
