package ch.bfh.bti7081.s2015.red.PatientApp.View;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import ch.bfh.bti7081.s2015.red.PatientApp.App.PatientApp;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Button.ClickEvent;

public class LifeUpOverviewView extends BaseView<Activity>{
	
	Calendar localCalendar 		= Calendar.getInstance();
	Date date 					= new Date();
	DateFormat outputFormatter 	= new SimpleDateFormat("dd.MM.yyyy");
	DateFormat timeFormatter	= new SimpleDateFormat("HH:mm");
	
	private ArrayList<Activity> entries;
	
	Label lblSoftTime;
	Label lblHardTime;
	Label lblTitle;
	Label lblStatusInProgress;
	Label lblStatusFinished;
	Label lblDate;
	Label lblEmpty;

	@Override
	public void buttonClick(ClickEvent event) {
		if (event.getButton().getCaption().equals(stringStartPage)) { 
			getUI().getNavigator().navigateTo(NavigatorUI.STARTSCREEN);		
		}	
	}

	@Override
	public void update(Activity model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ArrayList<Activity> data) {

	}

	@Override
	public void enter(ViewChangeEvent event) {
		this.removeAllComponents();
		// add the default homescreen button
		this.addComponent(addStartPageNavigation());
		buttonStartPage.addClickListener(this);
		// end of adding default navigation				
		
		lblTitle = new Label("Übersicht über alle Aktivitäten");
		lblTitle.addStyleName("h2");
        this.addComponent(lblTitle);
        
        lblStatusInProgress = new Label("In Progress");
        lblStatusInProgress.addStyleName("h3");
        this.addComponent(lblStatusInProgress);
		
        entries = PatientApp.getInstance().getCalendar().getAllActivites();
        
        // iterate through all entries
		for ( int i = 0; i < entries.size(); i++ ) {
			Activity currentActivity = entries.get(i);
			
			// display only entries which are currently in progress
			if ( currentActivity.getStateName().equals("InProgress") ) { 
				
				// get the name, start time and end time of each entry and display it
		 		this.addComponent(new Link(currentActivity.getShortName(), new ExternalResource(currentActivity.getUrl())));
            	lblDate = new Label("Datum: " + outputFormatter.format(currentActivity.getStartTime().getTime()));
        		this.addComponent(lblDate);
        		lblSoftTime = new Label("SoftTime: " + timeFormatter.format(currentActivity.getSoftTimeLimit().getTime()));
    			this.addComponent(lblSoftTime);
    			lblHardTime = new Label("HardTime: " + timeFormatter.format(currentActivity.getHardTimeLimit().getTime()));
    			this.addComponent(lblHardTime);
    			lblEmpty = new Label("");
    			this.addComponent(lblEmpty);
			}
		}
		lblStatusFinished = new Label("Finished");
        lblStatusFinished.addStyleName("h3");
        this.addComponent(lblStatusFinished);
        
        // iterate through all entries
        for(int i = 0; i < entries.size(); i ++){
        	Activity currentActivity = entries.get(i);
        	
        	// display only entries which are already finished
        	if(currentActivity.getStateName().equals("Closed"))
        	{
				// get the name, start time and end time of each entry and display it
        		this.addComponent(new Link(currentActivity.getShortName(), new ExternalResource(currentActivity.getUrl())));
            	lblDate = new Label("Erledigt am: " + outputFormatter.format(date.getTime()) + " um " + timeFormatter.format(date.getTime()));
        		this.addComponent(lblDate);
    			lblEmpty = new Label("");
    			this.addComponent(lblEmpty);
        	}        	
        }
	}
}
