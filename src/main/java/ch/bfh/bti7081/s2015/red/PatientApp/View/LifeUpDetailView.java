package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Button.ClickEvent;

public class LifeUpDetailView extends BaseView<Activity> {

	Calendar localCalendar 	= Calendar.getInstance();
	Date date 				= new Date();

	Label lblState;
	Label lblTitle;
	Label lblEmpty;
	
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
		this.removeAllComponents();
		
		lblTitle = new Label("Today: " + date.toString());
		lblTitle.addStyleName("h2");
        this.addComponent(lblTitle);
        
        localCalendar.setTime(date);
        localCalendar.add(Calendar.DATE, 1);
        
        
		for(Activity activity : data)
		{
			/*if(todayIsPressed)
			{
				if(activity.getStartTime().equals(date))
				{
					this.addComponent(new Link(activity.getShortName(), new ExternalResource(activity.getUrl())));
					lblState = new Label(activity.getStateName());
					this.addComponent(lblState);
				}
			}
			else if(tomorrowIsPressed)
			{
				date = localCalendar.getTime();
				else if(activity.getStartTime().equals(date))
				{
					this.addComponent(new Link(activity.getShortName(), new ExternalResource(activity.getUrl())));
					lblState = new Label(activity.getStateName());
					this.addComponent(lblState);
				}
			}*/
			
			
			this.addComponent(new Link(activity.getShortName(), new ExternalResource(activity.getUrl())));
			lblState = new Label(activity.getStateName());
			this.addComponent(lblState);
		}
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
	}
}
