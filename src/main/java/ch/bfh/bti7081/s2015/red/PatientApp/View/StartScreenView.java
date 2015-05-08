package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.CalendarEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.ViewListener;

import com.google.gwt.layout.client.Layout;
import com.google.gwt.thirdparty.guava.common.collect.Multiset.Entry;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;



public class StartScreenView extends  BaseView<CalendarEntry>{

	
	ArrayList<CalendarEntry> collection = new ArrayList<>();
	final Button medication = new Button("Medication");
	final Button update = new Button("Update");
	final TextField tf1 = new TextField("TextField");
	final TextField tf2 = new TextField("TextField");
	
	
	public StartScreenView()
	{
		Label label = new Label("Start Page");
		addComponent(label);
		medication.addClickListener(this);
		update.addClickListener(this);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		
		if(event.getSource() == medication)
			getUI().getNavigator().navigateTo(NavigatorUI.MEDICATIONINDEX);
		else if(event.getSource() == update)
		{
			  collection.get(0).setDisplay(tf1.getValue());
	    	  collection.get(1).setDisplay(tf2.getValue());
	   
	         for(ViewListener listener: listeners)
	         {
	        	 
	        	 listener.buttonClick("UPDATE",collection);
		     }
		}
			
	}
	@Override
	public void enter(ViewChangeEvent event) {
		
		//tf1.setValue(collection.get(0).display());
		//tf2.setValue(collection.get(1).display());
		
		addComponent(tf1);
		addComponent(tf2);
		addComponent(medication);
		addComponent(update);
	}

	@Override
	public void update(CalendarEntry model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ArrayList<CalendarEntry> data) {
		collection =data;
		
	}
}
