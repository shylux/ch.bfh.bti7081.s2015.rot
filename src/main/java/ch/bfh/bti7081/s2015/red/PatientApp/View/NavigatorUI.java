package ch.bfh.bti7081.s2015.red.PatientApp.View;

import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.*;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.Navigator.ComponentContainerViewDisplay;
import com.vaadin.server.VaadinRequest;
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
public class NavigatorUI extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 614340462216711328L;

	Navigator navigator;

	final public static String MEDICATIONINDEX 	= "MedicationIndex";
	final public static String EMERGENCY 		= "Emergency";
	final public static String GPSACTIVTY 		="GpsActivity";
	final public static String LIFEUPDETAIL 	= "LifeUpDetail";
	final public static String LIFEUPINDEX 		= "LifeUpIndex";
	final public static String LIFEUPOVERVIEW 	= "LifeUpOverview";
	final public static String CALENDARINDEX 	= "Kalender";

	@Override
	protected void init(VaadinRequest request) {
		// TODO Auto-generated method stub


		final VerticalLayout layout = new VerticalLayout();
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
		 * Life Up detail view
		 */
		LifeUpDetailView lifeUpDetailView =  new LifeUpDetailView();
		LifeUpDetailPreseter lifeUpDetailPresenter = new LifeUpDetailPreseter(lifeUpDetailView);
		lifeUpDetailView.addListener(LIFEUPDETAIL, lifeUpDetailPresenter);
		navigator.addView(LIFEUPDETAIL, lifeUpDetailView);
		
		/*
		 * Life Up Overview
		 */
		LifeUpOverviewView lifeUpOverviewView = new LifeUpOverviewView();
		LifeUpOverviewPresenter lifeUpOverviewPresenter = new LifeUpOverviewPresenter(lifeUpOverviewView);
		lifeUpOverviewView.addListener(LIFEUPOVERVIEW, lifeUpOverviewPresenter);
		navigator.addView(LIFEUPOVERVIEW, lifeUpOverviewView);
		
		//navigator.navigateTo(GPSACTIVTY+"/personalData");
		 
	}
}
