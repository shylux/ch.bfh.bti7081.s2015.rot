package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;

import java.util.ArrayList;
import java.util.Date;

import ch.bfh.bti7081.s2015.red.PatientApp.Db.MongoDbAdapter;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.TimeActivityManager;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.TimeActivityReady;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.GpsActivity;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.LifeUpProgressModel;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.StartPageModel;
import ch.bfh.bti7081.s2015.red.PatientApp.View.View;

/**
 * Creates the LifeUpProgressPresenter forwards the view to the super class.
 * 
 * @param	View forward the View to the super class.
 */	
public class LifeUpProgressPresenter extends BasePresenter<Activity>{

	/**
	 * Creates the LifeUpProgressPresenter forwards the view to the super class.
	 * 
	 * @param	View forward the View to the super class.
	 */	
	public LifeUpProgressPresenter(View view) {
		super(view);
	}

	@Override
	public void buttonClick(String property, Activity data) {
		// TODO Auto-generated method stub
	}

	@Override
	public void buttonClick(String property, ArrayList<Activity> data) {
		// TODO Auto-generated method stub
	}

	@Override
	public void triggerEvent(String event, Activity data) {
		// TODO Auto-generated method stub
	}

}
