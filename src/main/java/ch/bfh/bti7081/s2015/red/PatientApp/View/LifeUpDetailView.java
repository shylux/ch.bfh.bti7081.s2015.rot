package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import ch.bfh.bti7081.s2015.red.PatientApp.lifeUp.LifeUp;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Button.ClickEvent;

public class LifeUpDetailView extends BaseView<LifeUp> {

	Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
	int currentDay = localCalendar.get(Calendar.DATE);
	
	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(LifeUp model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ArrayList<LifeUp> data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
		Label label = new Label(" " + currentDay);
        addComponent(label);
		
	}

}
