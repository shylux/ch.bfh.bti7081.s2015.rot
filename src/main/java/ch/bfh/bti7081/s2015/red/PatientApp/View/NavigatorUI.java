package ch.bfh.bti7081.s2015.red.PatientApp.View;

import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.EmergencyPresenter;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.MedicationIndexPresenter;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.MedicationPresenter;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.StartPagePresenter;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.Navigator.ComponentContainerViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@Widgetset("ch.bfh.bti7081.s2015.red.PatientApp.MyAppWidgetset")
public class NavigatorUI extends UI {

	protected Navigator navigator;

	final public static String MEDICATIONINDEX = "MedicationIndex";
	final public static String MEDICATION = "MedicationEntry";
	final public static String EMERGENCY = "Emergency";

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
		StartScreenView startScreenView = new StartScreenView();
		StartPagePresenter startScreenPresenter = new StartPagePresenter(
				startScreenView);
		startScreenView.addListener("StartScreen", startScreenPresenter);

		/*
		 * Medication Index MVP
		 */
		MedicationIndexView mediIndexView = new MedicationIndexView();
		MedicationIndexPresenter mediIndexPresenter = new MedicationIndexPresenter(
				mediIndexView);
		mediIndexView.addListener(MEDICATIONINDEX, mediIndexPresenter);
		
		/*
		 * Medication MVP
		 */
		MedicationView mediView = new MedicationView();
		MedicationPresenter mediPresenter = new MedicationPresenter(
				mediView);
		mediView.addListener(MEDICATION, mediPresenter);
		
		/*
		 * Emergency MVP
		 */
		EmergencyView emergView = new EmergencyView();
		EmergencyPresenter emergPresenter = new EmergencyPresenter(emergView);
		emergView.addListener(EMERGENCY, emergPresenter);

		navigator.addView("", startScreenView);
		navigator.addView(MEDICATIONINDEX, mediIndexView);
		navigator.addView(MEDICATION, mediView);
		navigator.addView(EMERGENCY, emergView);

		// navigator.navigateTo("");
	}

}
