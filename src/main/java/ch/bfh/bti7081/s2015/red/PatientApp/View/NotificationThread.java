package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.App.PatientApp;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.CalendarEntry;

import com.vaadin.ui.Layout;
import com.vaadin.ui.UI;



/**
 * a thread that creates a reminder overlay 
 * when a gps activty will end soon or a appointment / medication 
 * entry started in the next few hours 
 * @author James Mayr
 *
 */
public class NotificationThread extends Thread 
{
	/**
	 * delay for notification update
	 */
	final private static int DELAY = 5000;
	
	/**
	 * all temporary stored notifications
	 */
	ArrayList<CalendarEntry>entries;
	
	/**
	 *  a reminder component for the overlay
	 */
	ReminderComponent reminderComponent = null;
	
	/**
	 * to check if the thread is running or already stopped
	 */
	boolean isRunning = true;
	
	/**
	 * reference of the layout
	 */
	Layout layout;
	
	
	/**
	 * creates a new notification thread with a given layout
	 * (is necessary for adding the reminder overlay)
	 * @param layout
	 */

	public NotificationThread(Layout layout)
	{
		this.layout = layout;
	}
	/**
	 * start the thread
	 */

	public void start()
	{	
		isRunning=true;
		super.start();
	}
	public void run() {
	    try {
	        // Update the data for a while
	        while (isRunning) {

	            Thread.sleep(DELAY);
	            
	            //get all relevant notifications from the calendar

	            entries = PatientApp.getInstance().getCalendar().getNotifications();
	            UI.getCurrent().access(new Runnable() 
	            {
	                @Override
	                public void run() 
	                {
	                	if(isRunning && entries.size() >0)
	                	{

	                		/*
	                		 * create a reminder Component
	                		 */

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

	/**
	 * stop the notifcation thread
	 */

	public void stopThread()
	{
		UI.getCurrent().access(new Runnable() {
			public void run()
			{
				if(reminderComponent != null)
					layout.removeComponent(reminderComponent);
				isRunning = false;
			}
		});
	}
}