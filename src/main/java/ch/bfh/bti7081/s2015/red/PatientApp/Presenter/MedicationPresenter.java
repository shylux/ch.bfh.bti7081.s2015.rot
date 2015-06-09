package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;

import java.util.ArrayList;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.bti7081.s2015.red.PatientApp.Db.MongoDbAdapter;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.GpsActivity;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.MedicationEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.BasePresenter;
import ch.bfh.bti7081.s2015.red.PatientApp.View.View;

public class MedicationPresenter extends BasePresenter<MedicationEntry>{

	protected MedicationEntry medication;
	
	public MedicationPresenter(View view) {
		super(view);
		//view.update(medication);
	}


	@Override
	public void buttonClick(String property, MedicationEntry data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buttonClick(String property, ArrayList<MedicationEntry> data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void triggerEvent(String event, MedicationEntry data) {
		// TODO Auto-generated method stub
		System.out.println(data);
		if(event.equals("loadActivity"))
		{
			MongoDbAdapter adapter = new MongoDbAdapter();
			data = (MedicationEntry) adapter.getEntryFromDatabase(data);
			view.update(data);
			
		}
	}

}
