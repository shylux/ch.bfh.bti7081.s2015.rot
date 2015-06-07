package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;


import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.DbInitializer;
import ch.bfh.bti7081.s2015.red.PatientApp.Db.MongoDbAdapter;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.MedicationEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.View.View;

public class MedicationIndexPresenter extends BasePresenter<MedicationEntry> {
	
	protected ArrayList<MedicationEntry> entries = new ArrayList<MedicationEntry>();

	public MedicationIndexPresenter(View<MedicationEntry> view) {
		super(view);
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

}
