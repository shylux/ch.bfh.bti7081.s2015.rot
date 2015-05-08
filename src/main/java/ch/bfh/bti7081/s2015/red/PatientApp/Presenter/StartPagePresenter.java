package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Appointment;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.CalendarEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.MedicationEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.App.Appointment;
import ch.bfh.bti7081.s2015.red.PatientApp.App.CalendarEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.App.EmergencyStep;
import ch.bfh.bti7081.s2015.red.PatientApp.App.MedicationEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.CalendarEntryModel;
import ch.bfh.bti7081.s2015.red.PatientApp.View.StartScreenView;
import ch.bfh.bti7081.s2015.red.PatientApp.View.View;

public class StartPagePresenter  extends BasePresenter<CalendarEntry> {

	private CalendarEntry[] model;

	public StartPagePresenter(View view) {
		super(view);

		CalendarEntryModel model1 = new CalendarEntryModel();
		model1.add(new Appointment());
		model1.add(new MedicationEntry());
		model = model1;

		((StartScreenView)this.view).update(model.getCollection());
	}

	@Override
	public void buttonClick(String property, CalendarEntry data) {
		// TODO Auto-generated method stub

	}



	@Override
	public void triggerEvent(String event, CalendarEntry data) {
		// TODO Auto-generated method stub

	}



	@Override
	public void buttonClick(String property, ArrayList<CalendarEntry> data) {

/*
		if(property.equals("UPDATE"))
		{
			this.model.update();
			for(CalendarEntry entry : this.model.getCollection())
				System.out.println(entry.display());
		}*/

	}

}
