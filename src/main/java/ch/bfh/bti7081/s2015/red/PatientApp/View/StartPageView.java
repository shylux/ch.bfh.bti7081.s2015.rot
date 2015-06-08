package ch.bfh.bti7081.s2015.red.PatientApp.View;


import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Appointment;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.CalendarEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.ViewListener;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * The view for the StartPage. Handles the all user inputs.
 * @author Stefan Tanner
 *
 */		
public class StartPageView extends BaseView<CalendarEntry> {

	private String stringNext = "vorwärts";
	private String stringPrevious = "rückwärts";
	private String stringSOS = "SOS";
	private String stringMedication = "Medikamente";
	private String stringLifeUp = "Life Up";
	private String stringContacts = "Kontakte";
	private String stringCalendar = "Kalender";

	final Button buttonDailyEventsNext = new Button(stringNext);
	final Button buttonDailyEventsPrevious = new Button(stringPrevious);
	final Button buttonSOS = new Button(stringSOS);
	final Button buttonMedication = new Button(stringMedication);
	final Button buttonLifeUp = new Button(stringLifeUp);
	final Button buttonContacts = new Button(stringContacts);
	final Button buttonCalender = new Button(stringCalendar);

	private Label labelDailyEventsTitle = new Label();
	private Label labelDailyEventsDescription = new Label();

	private Appointment appointmentCurrent;

	/**
	 * Creates the StartPageModel and sets the ClickListener to the buttons.
	 *  
	 */	
	public StartPageView() {
		// Add all required listeners to the buttons
		buttonDailyEventsNext.addClickListener(this);
		buttonDailyEventsPrevious.addClickListener(this);
		buttonSOS.addClickListener(this);
		buttonMedication.addClickListener(this);
		buttonLifeUp.addClickListener(this);
		buttonContacts.addClickListener(this);
		buttonCalender.addClickListener(this);
	}

	@Override
	public void buttonClick(ClickEvent event) {

		String property = event.getButton().getCaption();

		if (property.equals(stringLifeUp)) {
			getUI().getNavigator().navigateTo(NavigatorUI.LIFEUPINDEX);
		} else if (property.equals(stringMedication)) {
			getUI().getNavigator().navigateTo(NavigatorUI.MEDICATIONINDEX);
		} else if (property.equals(stringSOS)) {
			getUI().getNavigator().navigateTo(NavigatorUI.EMERGENCY);
		} else if (property.equals(stringCalendar)) {
			getUI().getNavigator().navigateTo(NavigatorUI.CALENDARINDEX);
		} else if (property.equals(stringContacts)) {
		} else if (property.equals(stringPrevious)
				|| property.equals(stringNext)) { 


			for (ViewListener listener : listeners) {
				listener.buttonClick(property, appointmentCurrent);
			}

		}
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// Fixed Bug that all components got redrawn after forward/back
		// navigation.
		this.removeAllComponents();

		String stringMenuButtonSize = "130px";

		buttonSOS.setStyleName("red");
		buttonSOS.setWidth("70px");
		buttonSOS.setHeight("70px");

		// Crafts the layout
		VerticalLayout dailyEventsContainer = new VerticalLayout();

		HorizontalLayout line0 = new HorizontalLayout();
		HorizontalLayout lineMenu1 = new HorizontalLayout();
		HorizontalLayout lineMenu2 = new HorizontalLayout();
		VerticalLayout layoutVertical = new VerticalLayout();
		layoutVertical.setWidth("400px");

		layoutVertical.addComponent(buttonSOS);
		layoutVertical.setComponentAlignment(buttonSOS, Alignment.TOP_RIGHT);

		labelDailyEventsTitle.addStyleName("h1");
		labelDailyEventsDescription.addStyleName("h3");

		labelDailyEventsDescription.setHeight("60px");

		dailyEventsContainer.addComponent(labelDailyEventsTitle);
		dailyEventsContainer.addComponent(labelDailyEventsDescription);

		layoutVertical.addComponent(dailyEventsContainer);

		buttonDailyEventsNext.setWidth("160px");
		buttonDailyEventsPrevious.setWidth("160px");

		line0.addComponent(buttonDailyEventsPrevious);
		line0.addComponent(buttonDailyEventsNext);

		layoutVertical.addComponent(line0);

		Label margin = new Label("");
		margin.setWidth(null);
		margin.setHeight("30px");
		layoutVertical.addComponent(margin);

		buttonMedication.setWidth(stringMenuButtonSize);
		buttonMedication.setHeight(stringMenuButtonSize);
		buttonLifeUp.setWidth(stringMenuButtonSize);
		buttonLifeUp.setHeight(stringMenuButtonSize);

		lineMenu1.addComponent(buttonMedication);
		lineMenu1.addComponent(buttonLifeUp);
		layoutVertical.addComponent(lineMenu1);

		buttonContacts.setWidth(stringMenuButtonSize);
		buttonContacts.setHeight(stringMenuButtonSize);
		buttonCalender.setWidth(stringMenuButtonSize);
		buttonCalender.setHeight(stringMenuButtonSize);

		lineMenu2.addComponent(buttonContacts);
		lineMenu2.addComponent(buttonCalender);
		layoutVertical.addComponent(lineMenu2);
		addComponent(layoutVertical);
		

		NavigatorUI.notificationThread = new NotificationThread(layoutVertical);
		NavigatorUI.notificationThread.start();
		

	}

	@Override
	public void update(CalendarEntry model) {
		labelDailyEventsTitle.setValue(model.getShortName());
		labelDailyEventsDescription.setValue(model.getDescription());
	}

	@Override
	public void update(ArrayList<CalendarEntry> data) {

	}
}
