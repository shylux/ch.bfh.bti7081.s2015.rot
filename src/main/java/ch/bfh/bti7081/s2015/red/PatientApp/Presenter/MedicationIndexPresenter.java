package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;

import java.util.ArrayList;

import com.vaadin.navigator.Navigator;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.CalendarEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.MedicationEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.View.View;

public class MedicationIndexPresenter extends BasePresenter<MedicationEntry> {
	
	protected ArrayList<MedicationEntry> entries = new ArrayList<MedicationEntry>();

	public MedicationIndexPresenter(View view) {
		super(view);
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
	
	public ArrayList<MedicationEntry> getCollection() {
		ArrayList<String> tmp = new ArrayList<String>();
		tmp.add("diese Zeit");
		tmp.add("und diese Zeit");
		entries.add(new MedicationEntry("name", "beschreibung", "so oft am tag", "oral",tmp));
		return entries;
	}
	
	public void add(MedicationEntry o) {
		entries.add(o);
	}


	public MedicationEntry getData() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void update() {
		
		
	}


}
