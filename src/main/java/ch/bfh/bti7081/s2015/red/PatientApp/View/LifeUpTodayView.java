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

public class LifeUpTodayView extends BaseView<Activity> {

	Calendar localCalendar 		= Calendar.getInstance();
	Date date 					= new Date();
	DateFormat outputFormatter 	= new SimpleDateFormat("dd.MM.yyyy");

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
		this.removeAllComponents();
		
		this.addComponent(addStartPageNavigation());
		buttonStartPage.addClickListener(this);
		
		lblTitle = new Label("Heute: " + outputFormatter.format(date));
		lblTitle.addStyleName("h2");
        this.addComponent(lblTitle);
        
        localCalendar.setTime(date);
        localCalendar.add(Calendar.DATE, 1);
        
		for(Activity activity : data)
		{
			if(activity.getStartTime().getDay() == date.getDay())
			{
				this.addComponent(new Link(activity.getShortName(), new ExternalResource(activity.getUrl())));
				lblState = new Label(activity.getStateName());
				this.addComponent(lblState);				
			}
		}
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
	}
}
