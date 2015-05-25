package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.Db.MongoDbAdapter;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.CalendarEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.GpsActivity;
import ch.bfh.bti7081.s2015.red.PatientApp.View.View;
import ch.bfh.bti7081.s2015.red.PatientApp.lifeUp.Circle;
import ch.bfh.bti7081.s2015.red.PatientApp.lifeUp.GpsCoordinate;

public class GpsActivityPresenter  extends BasePresenter<GpsActivity>{

	public GpsActivityPresenter(View view) {
		super(view);
		
	}

	@Override
	public void buttonClick(String property, GpsActivity data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buttonClick(String property, ArrayList<GpsActivity> data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void triggerEvent(String event, GpsActivity data) {
		if(event.equals("loadActivity"))
		{
			System.out.println("DATA:"+data);
			MongoDbAdapter adapter = new MongoDbAdapter();
			data = (GpsActivity) adapter.getEntryFromDatabase(data);
			view.update(data);
			
		}
		
	}
}
