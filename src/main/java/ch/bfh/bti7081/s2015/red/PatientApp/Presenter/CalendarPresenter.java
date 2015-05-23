package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.DbInitializer;
import ch.bfh.bti7081.s2015.red.PatientApp.Db.MongoDbAdapter;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.CalendarEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.View.View;

public class CalendarPresenter extends BasePresenter<CalendarEntry>{

	private ArrayList<CalendarEntry> entries;
	public CalendarPresenter(View<CalendarEntry> view) {
		super(view);
		DbInitializer.restore();
		MongoDbAdapter adapter = new MongoDbAdapter();
		entries = adapter.getSpecificCollection(CalendarEntry.class, true);
		
		view.update(entries);
	}

	@Override
	public void buttonClick(String property, CalendarEntry data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buttonClick(String property, ArrayList<CalendarEntry> data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void triggerEvent(String event, CalendarEntry data) {
		// TODO Auto-generated method stub
		
	}

}
