package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;

<<<<<<< HEAD
import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.DbInitializer;
import ch.bfh.bti7081.s2015.red.PatientApp.Db.MongoDbAdapter;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.GpsActivity;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.MedicationEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.View.View;

public class MedicationIndexPresenter extends BasePresenter<MedicationEntry> {
	
	protected ArrayList<MedicationEntry> entries = new ArrayList<MedicationEntry>();
=======
import ch.bfh.bti7081.s2015.red.PatientApp.Model.CalendarEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.View.View;

import java.util.ArrayList;

public class MedicationIndexPresenter extends BasePresenter<CalendarEntry> {
>>>>>>> 96afefa576f20fc044f3d06bcf44943d691fa814

	public MedicationIndexPresenter(View<MedicationEntry> view) {
		super(view);
		DbInitializer.restore();
		MongoDbAdapter adapter = new MongoDbAdapter();
		entries = adapter.getSpecificCollection(MedicationEntry.class);
		view.update(entries);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void buttonClick(String property, MedicationEntry data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void triggerEvent(String event, MedicationEntry data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buttonClick(String property, ArrayList<MedicationEntry> data) {
		// TODO Auto-generated method stub
		
	}
	
	public void update(MedicationEntry data) {
		int index = entries.indexOf(data);
		entries.set(index, data);
	}
	
	public void add(MedicationEntry o) {
		entries.add(o);
	}


	public ArrayList<MedicationEntry> getData() {
		// TODO Auto-generated method stub

		ArrayList<String> tmp = new ArrayList<String>();
		tmp.add("diese Zeit");
		tmp.add("und diese Zeit");
		entries.add(new MedicationEntry("name", "beschreibung", "so oft am tag", "oral",tmp));
		entries.add(new MedicationEntry("name2", "beschreibung2", "so oft am tag 2", "oral 2",tmp));
		return entries;
	}
	
	public void update() {
		
		
	}


}
