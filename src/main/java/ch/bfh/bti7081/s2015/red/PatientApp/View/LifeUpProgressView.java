package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;


import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.bti7081.s2015.red.PatientApp.App.PatientApp;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.CalendarEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.LifeUpProgressModel;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.ViewListener;

/**
 * The view for the LifeUpProgress. Displays progress and finished activites
 * @author Stefan Tanner
 *
 */		
public class LifeUpProgressView  extends BaseView <Activity>{

	final private String strTitle = "LifeUp-Fortschritt";
	final private String strLevel = " Level "; 
	final private String strFinished = "Abgeschlossene Aufgaben";
	
	private final ArrayList progressData = (new LifeUpProgressModel()).getProgressData();
	
	final Label labelProgress = new Label();
	final Label labelTitle = new Label(strTitle);
	final Label labelFinished = new Label(strFinished);
	final ProgressBar barlifeUpProgress = new ProgressBar(0.0f);
	
	private ArrayList<Activity> entries;
	
	@Override
	public void enter(ViewChangeEvent event) {
		this.removeAllComponents();
		
		// add the default homescreen button
		this.addComponent(addStartPageNavigation());
		buttonStartPage.addClickListener(this);
		// end of adding default navigation				
		
		labelTitle.addStyleName("h1");
		this.addComponent(labelTitle);  

        entries = PatientApp.getInstance().getCalendar().getAllActivites();
        VerticalLayout layoutVertical = new VerticalLayout(); 
        
		layoutVertical.setWidth("400px");
        barlifeUpProgress.setWidth("300px"); 
       
        labelProgress.setValue(displayCurrentXP()); 
        labelProgress.setHeight("30px");
        
        layoutVertical.addComponent(barlifeUpProgress);	
		layoutVertical.addComponent(labelProgress);
		
		labelFinished.addStyleName("h2");
		layoutVertical.addComponent(labelFinished);

		VerticalLayout layoutFinishedTable = new VerticalLayout();
		
		// loop through the ArrayList of Activites and all all Activites which are Closed.
		for ( int i = 0; i < entries.size(); i++ ) {
			Activity currentActivity = entries.get(i); 
			if ( currentActivity.getStateName().equals("Closed") ) { 
				HorizontalLayout layoutFinished = new HorizontalLayout();
				Label labelActivityName = new Label(currentActivity.getShortName());
				labelActivityName.setWidth("300px");
				Label labelActivityPoints = new Label("" + currentActivity.getGivenPoints());
				labelActivityPoints.setWidth("50px");
				layoutFinished.addComponent(labelActivityName);
				layoutFinished.addComponent(labelActivityPoints);
				layoutFinishedTable.addComponent(layoutFinished);
			}
		} 
		
		layoutVertical.addComponent(layoutFinishedTable);
	    this.addComponent(layoutVertical);
	}	
	
	/**
	 * Display the xp of the patient. Show it as an progress bar
	 *  
	 */	
	private String displayCurrentXP() {
		// TODO Auto-generated method stub
		
		int pointsGained = 0;
		
		for ( int i = 0; i < entries.size(); i++ ) {
			pointsGained += (int)(entries.get(i)).getGivenPoints();	
		}
	
<<<<<<< HEAD
		// calculate the current level's xp and the points needed until the next level.
		int currentLevel = calculateLevel(pointsGained); 
=======
		int currentLevel = calculateLevel(pointsGained); 
>>>>>>> ea0426ddbc9228ec23d9b4160cd723cd4c843ede
		int pointsUntilNextLevel = (int)progressData.get(currentLevel) - pointsGained;
		labelTitle.setValue(strTitle + strLevel + currentLevel);
		 
		int nextLevelXP = (int) progressData.get(currentLevel);

		// set the progressbar to the percent reached of the current level
		float progress = (float) ((float)pointsGained / (float)nextLevelXP);
		barlifeUpProgress.setValue(progress);
		
		return pointsGained + " / " + nextLevelXP + " (" + pointsUntilNextLevel + " Punkte bis zum nächste Level)";
	}

	/**
	 * Returns the current level
	 * @param	pointsGained	the current points the patient has gained through the Activites
	 * @return	level	the current level of the patient in LifeUp
	 */		
	private int calculateLevel(int pointsGained) {
		

		if ( pointsGained == 0 || (int)progressData.get(0) > pointsGained ) {
			return 0;
		}
		
		for ( int i = 0; i < progressData.size()-1; i++ ) {
			if ( (int)(progressData.get(i)) < pointsGained && (int)(progressData.get(i+1)) >= pointsGained ) {
				return i+1;
			}
		}
		
		return 0;
	}
	
	
	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		
		// Navigate to startscreen
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
		// TODO Auto-generated method stub
	}
}
