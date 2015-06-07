package ch.bfh.bti7081.s2015.red.PatientApp.View;

import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.CalendarPresenter;

import java.util.ArrayList;
import ch.bfh.bti7081.s2015.red.PatientApp.App.PatientApp;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.CalendarEntry;

import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.EmergencyPresenter;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.LifeUpTodayPreseter;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.LifeUpOverviewPresenter;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.GpsActivityPresenter;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.LifeUpIndexPresenter;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.LifeUpProgressPresenter;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 614340462216711328L;


	Navigator navigator;

	final public static String STARTSCREEN		= "StartScreen";
	final public static String MEDICATIONINDEX 	= "MedicationIndex";
	final public static String EMERGENCY 		= "Emergency";
	final public static String GPSACTIVTY 		= "GpsActivity";
	final public static String LIFEUPTODAY	 	= "LifeUpToday";
	final public static String LIFEUPTOMORROW	= "LifeUpTomorrow";
	final public static String LIFEUPINDEX 		= "LifeUpIndex";
	final public static String LIFEUPOVERVIEW 	= "LifeUpOverview";
	final public static String CALENDARINDEX 	= "Kalender";
	final public static String LIFEUPPROGRESS   = "Fortschritt";

	final public static String LIFEUP = "LifeUp";

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
		 * Startstreen MVP
		 */
		StartPageView startPageView = new StartPageView();
		StartPagePresenter startScreenPresenter = new StartPagePresenter(
				startPageView);
		startPageView.addListener(STARTSCREEN, startScreenPresenter);

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
		navigator.addView(STARTSCREEN, startPageView);
		navigator.addView(MEDICATIONINDEX, mediIndexView);
		navigator.addView(EMERGENCY, emergView);
		
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
		CalendarView calendarView = new CalendarView(navigator);
		CalendarPresenter calendarPresenter = new CalendarPresenter(calendarView);
		calendarView.addListener(CALENDARINDEX, calendarPresenter);
		navigator.addView(CALENDARINDEX, calendarView);
		
		/*
		 * Life Up Activity overview
		 */
		LifeUpIndexView lifeUpIndexView = new LifeUpIndexView();
		LifeUpIndexPresenter lifeUpIndexPresenter = new LifeUpIndexPresenter(lifeUpIndexView);
		lifeUpIndexView.addListener(LIFEUPINDEX,lifeUpIndexPresenter);
		navigator.addView(LIFEUPINDEX, lifeUpIndexView);
		
		/*
		 * Life Up today view
		 */
		LifeUpTodayView lifeUpTodayView =  new LifeUpTodayView();
		LifeUpTodayPreseter lifeUpTodayPresenter = new LifeUpTodayPreseter(lifeUpTodayView);
		lifeUpTodayView.addListener(LIFEUPTODAY, lifeUpTodayPresenter);
		navigator.addView(LIFEUPTODAY, lifeUpTodayView);
		
		/*
		 * Life Up detail view
		 */
		LifeUpTomorrowView lifeUpTomorrowView =  new LifeUpTomorrowView();
		LifeUpTodayPreseter lifeUpTomorrowPresenter = new LifeUpTodayPreseter(lifeUpTomorrowView);
		lifeUpTomorrowView.addListener(LIFEUPTOMORROW, lifeUpTomorrowPresenter);
		navigator.addView(LIFEUPTOMORROW, lifeUpTomorrowView);
		
		/*
		 * Life Up Overview
		 */
		LifeUpOverviewView lifeUpOverviewView = new LifeUpOverviewView();
		LifeUpOverviewPresenter lifeUpOverviewPresenter = new LifeUpOverviewPresenter(lifeUpOverviewView);
		lifeUpOverviewView.addListener(LIFEUPOVERVIEW, lifeUpOverviewPresenter);
		navigator.addView(LIFEUPOVERVIEW, lifeUpOverviewView);
		

		 /** View for restoring data
		 * @TODO: Remove for production
		 */
		navigator.addView(RESTORE, new RestoreView());

		/*
		 * Life Up Progress
		 */
		LifeUpProgressView lifeUpProgressView = new LifeUpProgressView();
		LifeUpProgressPresenter lifeUpProgressPresenter = new LifeUpProgressPresenter(lifeUpProgressView);
		lifeUpOverviewView.addListener(LIFEUPPROGRESS, lifeUpProgressPresenter);
		navigator.addView(LIFEUPPROGRESS, lifeUpProgressView);
		 
	}
	
}


