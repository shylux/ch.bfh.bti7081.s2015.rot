package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.CalendarEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.StartPageModel;
import ch.bfh.bti7081.s2015.red.PatientApp.View.View;

import java.util.ArrayList;

/**
 * The presenter for the StartPage. Handles the event between model and view.
 * @author Stefan Tanner
 *
 */		
public class StartPagePresenter  extends BasePresenter<CalendarEntry> {

	private CalendarEntry modelCalenderEntry;
	private StartPageModel modelStartPage;

	/**
	 * Creates the StartPageModel an gets the data from the calendar.
	 * 
	 * @param	View forward the View to the super class.
	 */	
	public StartPagePresenter(View view) {
		super(view);
		modelStartPage = new StartPageModel();
		modelCalenderEntry = modelStartPage.next(null);
		view.update(modelCalenderEntry);		
	}

	@Override
	public void buttonClick(String property, CalendarEntry data) {
		
		if(property.equals("vorwärts")) {
			modelCalenderEntry = modelStartPage.next(data);
		}
		else {
			modelCalenderEntry = modelStartPage.previous(data);
		}
		
		view.update(modelCalenderEntry);
	}

	@Override
	public void triggerEvent(String event, CalendarEntry data) {
		// Not used required in the StartPage
	}

	@Override
	public void buttonClick(String property, ArrayList<CalendarEntry> data) {
		// Not used required in the StartPage
	}
}
