package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;



import ch.bfh.bti7081.s2015.red.PatientApp.DbInitializer;
import ch.bfh.bti7081.s2015.red.PatientApp.View.View;
import ch.bfh.bti7081.s2015.red.PatientApp.Db.MongoDbAdapter;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.LifeUp;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.TimeActivityManager;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.TimeActivityReady;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.GpsActivity;



import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.LifeUp;
import ch.bfh.bti7081.s2015.red.PatientApp.View.View;
import java.util.ArrayList;
import java.util.Date;

public class LifeUpOverviewPresenter extends BasePresenter<Activity> {

	private ArrayList<Activity> activities;
	
	public LifeUpOverviewPresenter(View view) {
		super(view);
		DbInitializer.restore();
		MongoDbAdapter adapter = new MongoDbAdapter();
		activities = adapter.getSpecificCollection(GpsActivity.class);		
 
		TimeActivityManager manager = TimeActivityManager.getInstance();
		
		long SECONDS_IN_MS = 1000;
		Date now = new Date();  
		
		for (int i = 0; i < activities.size(); i++) {
			Activity currentActivity = activities.get(i);
			currentActivity.setSoftTimeLimit(new Date(now.getTime() + (30 * SECONDS_IN_MS)));
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
