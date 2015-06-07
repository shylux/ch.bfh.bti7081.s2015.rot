package ch.bfh.bti7081.s2015.red.PatientApp.View;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
		this.removeAllComponents();
		
		this.addComponent(addStartPageNavigation());
		buttonStartPage.addClickListener(this);
		
		lblTitle = new Label("Übersicht über alle Aktivitäten");
		lblTitle.addStyleName("h2");
        this.addComponent(lblTitle);
        
        lblStatusInProgress = new Label("In Progress");
        lblStatusInProgress.addStyleName("h3");
        this.addComponent(lblStatusInProgress);

        for(int i = 0; i < data.size(); i ++)
        {
        	if(data.get(i).getStateName().equals("InProgress"))
        	{
        		this.addComponent(new Link(data.get(i).getShortName(), new ExternalResource(data.get(i).getUrl())));
            	lblDate = new Label("Datum: " + outputFormatter.format(data.get(i).getStartTime().getTime()));
        		this.addComponent(lblDate);
        		lblSoftTime = new Label("SoftTime: " + timeFormatter.format(data.get(i).getSoftTimeLimit().getTime()));
    			this.addComponent(lblSoftTime);
    			lblHardTime = new Label("HardTime: " + timeFormatter.format(data.get(i).getHardTimeLimit().getTime()));
    			this.addComponent(lblHardTime);
    			lblEmpty = new Label("");
    			this.addComponent(lblEmpty);
        	}        	
        }
        
        lblStatusFinished = new Label("Finished");
        lblStatusFinished.addStyleName("h3");
        this.addComponent(lblStatusFinished);
        for(int i = 0; i < data.size(); i ++)
        {
        	if(data.get(i).getStateName().equals("Finished"))
        	{
        		this.addComponent(new Link(data.get(i).getShortName(), new ExternalResource(data.get(i).getUrl())));
            	lblDate = new Label("Datum: " + outputFormatter.format(data.get(i).getStartTime().getTime()));
        		this.addComponent(lblDate);
        		lblSoftTime = new Label("SoftTime: " + outputFormatter.format(data.get(i).getSoftTimeLimit().getTime()));
    			this.addComponent(lblSoftTime);
    			lblHardTime = new Label("HardTime: " + outputFormatter.format(data.get(i).getHardTimeLimit().getTime()));
    			this.addComponent(lblHardTime);
        	}        	
        }
	}

	@Override
	public void enter(ViewChangeEvent event) {

	
		
	}
	
}
