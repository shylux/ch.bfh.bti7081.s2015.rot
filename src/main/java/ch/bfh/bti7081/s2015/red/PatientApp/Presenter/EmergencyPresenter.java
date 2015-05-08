package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.App.Emergency;
import ch.bfh.bti7081.s2015.red.PatientApp.View.View;

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
