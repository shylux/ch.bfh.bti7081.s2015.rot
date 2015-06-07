package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.MedicationEntry;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;

import ch.bfh.bti7081.s2015.red.PatientApp.DbInitializer;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.MedicationEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.MedicationIndexPresenter;


@Theme("mytheme")
@Widgetset("ch.bfh.bti7081.s2015.red.PatientApp.MyAppWidgetset")
public class MedicationIndexView extends BaseView<MedicationEntry>
{

	@Override
	public void enter(ViewChangeEvent event) {

        Label label = new Label("Medication");
        

		// add the default homescreen button
		this.addComponent(addStartPageNavigation());
		buttonStartPage.addClickListener(this);
		// end of adding default navigation	      
        
        addComponent(label);

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
	public void update(MedicationEntry model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(ArrayList<MedicationEntry> entries) {
		
		this.removeAllComponents();
		// Set all Links to Detail View of Medication
		for (MedicationEntry medication : entries) {
			System.out.println(medication.getUrl());
			addComponent(new Link(medication.getShortName(), new ExternalResource(medication.getUrl())));
		}
	}

}
