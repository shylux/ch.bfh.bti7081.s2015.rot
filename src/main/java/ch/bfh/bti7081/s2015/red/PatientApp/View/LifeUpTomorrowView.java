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

public class LifeUpTomorrowView extends BaseView<Activity>{
	Calendar localCalendar 		= Calendar.getInstance();
	Date dateTmr				= new Date();
	DateFormat outputFormatter 	= new SimpleDateFormat("dd.MM.yyyy");
	
	private ArrayList<Activity> entries;

	Label lblState;
	Label lblTitle;
	
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
				
        localCalendar.setTime(dateTmr);
        localCalendar.add(Calendar.DATE, 1);
        dateTmr = localCalendar.getTime();
		
		lblTitle = new Label("Morgen: " + outputFormatter.format(dateTmr));
		lblTitle.addStyleName("h2");
        this.addComponent(lblTitle);

        entries = PatientApp.getInstance().getCalendar().getAllActivites();
        for(int i = 0; i < entries.size(); i ++){
        	Activity currentActivity = entries.get(i);
        	
        	// display only entries which are in progress
        	if(currentActivity.getStateName().equals("InProgress"))
        	{
        		// check the day to make sure only tomorrows entries are displayed
        		if(currentActivity.getStartTime().getDate() == dateTmr.getDate())
    			{
    				this.addComponent(new Link(currentActivity.getShortName(), new ExternalResource(currentActivity.getUrl())));
    				lblState = new Label(currentActivity.getStateName());
    				this.addComponent(lblState);
    			}        		
        	}
			
		}
	}
}
