package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.MedicationEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.MedicationIndexPresenter;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.MedicationPresenter;


@Theme("mytheme")
@Widgetset("ch.bfh.bti7081.s2015.red.PatientApp.MyAppWidgetset")
public class MedicationIndexView extends BaseView<MedicationEntry>
{
	private MedicationIndexPresenter entries = new MedicationIndexPresenter(null);
	private NavigatorUI navigation = new NavigatorUI();

	@Override
	public void enter(ViewChangeEvent event) {

		for (MedicationEntry medication : entries.getCollection()) {

			Button button = new Button("Eine Medikation");

			button.addClickListener(new Button.ClickListener() {
				public void buttonClick(ClickEvent event) {
					/*
					 * Medication MVP
					 */
					MedicationView mediView = new MedicationView();
					MedicationPresenter mediPresenter = new MedicationPresenter(mediView);
					getUI().getNavigator().navigateTo(NavigatorUI.MEDICATION);
				}
			});
			addComponent(button);
		}
		
		// setContent(layout);
		Label label = new Label("Medication");

		addComponent(label);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		Label label = new Label("Button geklickt");
		addComponent(label);
	}

	@Override
	public void update(MedicationEntry model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(ArrayList<MedicationEntry> data) {
		// TODO Auto-generated method stub
		//this.entries = data;

	}
}
