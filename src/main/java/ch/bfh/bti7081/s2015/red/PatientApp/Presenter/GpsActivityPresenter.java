package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;

import java.util.ArrayList;




import ch.bfh.bti7081.s2015.red.PatientApp.Db.MongoDbAdapter;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.TimeActivityManager;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.GpsActivity;
import ch.bfh.bti7081.s2015.red.PatientApp.View.View;


public class GpsActivityPresenter  extends BasePresenter<GpsActivity>{

	public GpsActivityPresenter(View view) {
		super(view);
		
	}

	@Override
	public void buttonClick(String property, GpsActivity data) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void triggerEvent(String event, GpsActivity data) {
		if(event.equals("loadActivity"))
		{  
			MongoDbAdapter adapter = new MongoDbAdapter();
			data = (GpsActivity) adapter.getEntryFromDatabase(data);
			
			// TODO: AddCaleneder
			TimeActivityManager manager = TimeActivityManager.getInstance();
			manager.chooseActivity(data);
			data = (GpsActivity)manager.getActivity();
			manager.chooseActivity(data);
		
			data = (GpsActivity)manager.getActivity();
			view.update(data);
			
		}
		else if(event.equals("enteredToTarget")) { 
			TimeActivityManager manager = TimeActivityManager.getInstance();
			manager.chooseActivity(data);
			manager.nextState();
		}
		
	}

	@Override
	public void buttonClick(String property, ArrayList<GpsActivity> data) {
		// TODO Auto-generated method stub
		
	}
}
