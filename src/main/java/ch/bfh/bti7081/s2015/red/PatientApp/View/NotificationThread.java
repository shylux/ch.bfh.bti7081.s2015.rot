package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.App.PatientApp;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.CalendarEntry;

import com.vaadin.ui.Component;
import com.vaadin.ui.Layout;
import com.vaadin.ui.UI;

public class NotificationThread extends Thread 
{
	
	ArrayList<CalendarEntry>entries;	
	ReminderComponent reminderComponent = null;
	boolean isRunning = true;
	Layout layout;
	
	public NotificationThread(Layout layout)
	{
		this.layout = layout;
	}
	public void start()
	{	
		isRunning=true;
		super.start();
	}
	public void run() {
	    try {
	        // Update the data for a while
	        while (isRunning) {
	            Thread.sleep(2000);
	            entries = PatientApp.getInstance().getCalendar().getNotifications();
	            UI.getCurrent().access(new Runnable() 
	            {
	                @Override
	                public void run() 
	                {
	                	if(isRunning)
	                	{
	                    	if(reminderComponent != null)
	                    	{
	                    		layout.removeComponent(reminderComponent);
	                    	}
	                    	reminderComponent =new ReminderComponent(entries);
	                    	layout.addComponent(reminderComponent);
	                    }
	                }
	            });
	        }
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	public void stopThread()
	{
		UI.getCurrent().access(new Runnable() {
			public void run()
			{
				isRunning = false;
			}
		});
	}
}