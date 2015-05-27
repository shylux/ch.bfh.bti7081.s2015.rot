package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Emergency;
import ch.bfh.bti7081.s2015.red.PatientApp.View.View;

import java.util.ArrayList;

public class EmergencyPresenter extends BasePresenter<Emergency> {
	
	Emergency model = new Emergency();

	public EmergencyPresenter(View view) {
		super(view);
		view.update(model);
	}

	@Override
	public void buttonClick(String property, Emergency data) {}

	@Override
	public void buttonClick(String property, ArrayList<Emergency> data) {}

	@Override
	public void triggerEvent(String event, Emergency data) {}

}
