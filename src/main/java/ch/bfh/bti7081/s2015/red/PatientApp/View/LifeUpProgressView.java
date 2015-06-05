package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public class LifeUpProgressView  extends BaseView <Activity>{

	final private String strTitle = "LifeUp-Fortschritt";
	
	@Override
	public void enter(ViewChangeEvent event) {
		this.removeAllComponents();
		
		Label title = new Label(strTitle);
		title.addStyleName("h1");
		this.addComponent(title);
	}	
	
	
	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Activity model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ArrayList<Activity> data) {
		// TODO Auto-generated method stub
		
	}
}
