package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.App.Appointment;
import ch.bfh.bti7081.s2015.red.PatientApp.App.MedicationEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.CalendarEntryModel;
import ch.bfh.bti7081.s2015.red.PatientApp.View.StartScreenView;
import ch.bfh.bti7081.s2015.red.PatientApp.View.View;

public class StartPagePresenter  extends BasePresenter implements ViewListener{

	private CalendarEntryModel model;
	
	public StartPagePresenter(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void buttonClick(String property, Object data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void triggerEvent(String event, Object data) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void init(Object data) {
		CalendarEntryModel model1 = new CalendarEntryModel();
		model1.add(new Appointment());
		model1.add(new MedicationEntry());
		model = model1;
		
		((StartScreenView)this.view).update(model.getCollection());
		
	}

}
