package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.App.PatientApp;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.EmergencyPresenter;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.LifeUpPresenter;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.GpsActivityPresenter;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.LifeUpIndexPresenter;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.MedicationIndexPresenter;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.StartPagePresenter;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.Navigator.ComponentContainerViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@Widgetset("ch.bfh.bti7081.s2015.red.PatientApp.MyAppWidgetset")

/**
 * First called Class 
 * Setup the navigation entries
 * @author James Mayr
 *
 */

@Push
public class NavigatorUI extends UI {

	protected Navigator navigator;

	final public static String MEDICATIONINDEX = "MedicationIndex";
	final public static String EMERGENCY = "Emergency";
	final public static String LIFEUP = "LifeUp";
	final public static String GPSACTIVTY ="GpsActivity";
	final public static String LIFEUPINDEX = "LifeUpIndex";
	final public static String RESTORE = "Restore";
	final protected VerticalLayout layout = new VerticalLayout();
	public static NotificationThread notificationThread = null;


	
	protected void init(VaadinRequest request) {
		// TODO Auto-generated method stub
		
		
		layout.setMargin(true);
		layout.setSpacing(true);
		setContent(layout);
		
		ComponentContainerViewDisplay viewDisplay = new ComponentContainerViewDisplay(
				layout);
		navigator = new Navigator(UI.getCurrent(), viewDisplay);
		
		/*
		 * startstreen MVP
		 */
		StartPageView startPageView = new StartPageView();
		StartPagePresenter startScreenPresenter = new StartPagePresenter(
				startPageView);
		startPageView.addListener("StartScreen", startScreenPresenter);

		/*
		 * Medication Index MVP
		 */
		MedicationIndexView mediIndexView = new MedicationIndexView();
		MedicationIndexPresenter mediIndexPresenter = new MedicationIndexPresenter(
				mediIndexView);
		mediIndexView.addListener(MEDICATIONINDEX, mediIndexPresenter);

		/*
		 * Emergency MVP
		 */
		EmergencyView emergView = new EmergencyView();
		EmergencyPresenter emergPresenter = new EmergencyPresenter(emergView);
		emergView.addListener(EMERGENCY, emergPresenter);

		navigator.addView("", startPageView);
		navigator.addView(MEDICATIONINDEX, mediIndexView);
		navigator.addView(EMERGENCY, emergView);
		
		/*
		 * LifeUp MVP
		 */
		LifeUpMainView lupMView = new LifeUpMainView();
		LifeUpPresenter luPresenter = new LifeUpPresenter(lupMView);
		lupMView.addListener(LIFEUP, luPresenter);
		navigator.addView(LIFEUP, lupMView);

		// navigator.navigateTo("");
		
		/*
		 * Life Up Gps Activity
		 */
		GpsActivityView gpsActvitivyView = new GpsActivityView();
		GpsActivityPresenter presenter= new GpsActivityPresenter(gpsActvitivyView);
		gpsActvitivyView.addListener(GPSACTIVTY,presenter);
		
		navigator.addView(GPSACTIVTY, gpsActvitivyView);
		
		/*
		 * Life Up Activity overview
		 */
		LifeUpIndexView lifeUpIndexView = new LifeUpIndexView();
		LifeUpIndexPresenter lifeUpIndexPresenter = new LifeUpIndexPresenter(lifeUpIndexView);
		lifeUpIndexView.addListener(LIFEUPINDEX,lifeUpIndexPresenter);
		navigator.addView(LIFEUPINDEX, lifeUpIndexView);
		
		/**
		 * View for restoring data
		 * @TODO: Remove for production
		 */
		navigator.addView(RESTORE, new RestoreView());
		
		notificationThread = new NotificationThread(layout);
		System.out.println("start...");
	
		
		
		
		 
	}
	class NotificationThread extends Thread {
	
	ArrayList<Activity>entries;	
	ReminderComponent reminderComponent = null;
	boolean isRunning = true;
	Layout layout;
    
	public NotificationThread(Layout layout)
	{
		this.layout = layout;
	}
	public void run() {
        try {
            // Update the data for a while
            while (isRunning) {
                Thread.sleep(2000);
                entries = PatientApp.getInstance().getCalendar().getUnfinishedActivity();
                access(new Runnable() {
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
		access(new Runnable() {
			public void run()
			{
				isRunning = false;
			}
		});
	}
}
	
}


