package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;


import ch.bfh.bti7081.s2015.red.PatientApp.View.View;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.LifeUp;

import java.util.ArrayList;

public class LifeUpOverviewPresenter extends BasePresenter<LifeUp> {

	LifeUp lup = new LifeUp();
	
	public LifeUpOverviewPresenter(View view) {
		super(view);
		view.update(lup);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void buttonClick(String property, LifeUp data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buttonClick(String property, ArrayList<LifeUp> data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void triggerEvent(String event, LifeUp data) {
		// TODO Auto-generated method stub
		
	}

}
