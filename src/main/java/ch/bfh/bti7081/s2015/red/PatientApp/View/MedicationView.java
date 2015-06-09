package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.MedicationEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.ViewListener;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@Theme("mytheme")
@Widgetset("ch.bfh.bti7081.s2015.red.PatientApp.MyAppWidgetset")
public class MedicationView extends BaseView<MedicationEntry>{
	
	
	MedicationEntry medication;
	
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MedicationEntry medicatonEntry) {
		this.removeAllComponents();
		medication = medicatonEntry;	
		addComponent(new Label("Medikation"));
		// Set Layout
		VerticalLayout content = new VerticalLayout();
		
		// Name Row
		HorizontalLayout nameLayout = new HorizontalLayout();
		nameLayout.addComponent(new Label("Name"));
		nameLayout.addComponent(new Label(medication.getName()));
		content.addComponent(nameLayout);
		
		// Description Row
		HorizontalLayout descriptionLayout = new HorizontalLayout();
		descriptionLayout.addComponent(new Label("Beschreibung"));
		descriptionLayout.addComponent(new Label(medication.getDescription()));
		content.addComponent(descriptionLayout);
		
		// Desciption "How much a Day" Row
		HorizontalLayout howMuchADayLayout = new HorizontalLayout();
		howMuchADayLayout.addComponent(new Label("Wie viel am Tag"));
		howMuchADayLayout.addComponent(new Label(medication.getHowMuchADay()));
		content.addComponent(howMuchADayLayout);

		
		// Times Row
		content.addComponent(new Label("Einnahmezeiten"));
		for(String times : medication.getTimes()){
			content.addComponent(new Label(times));
		}
		
		// Add some margin for style / place reasons
		content.setMargin(true);
		MarginInfo margin = new MarginInfo(5); 
		content.setMargin(margin);
		addComponent(content);
	}

	@Override
	public void update(ArrayList<MedicationEntry> data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		this.removeAllComponents();
		for(ViewListener<MedicationEntry> listener: listeners)
		{
			listener.triggerEvent("loadActivity", new MedicationEntry(event.getParameters()));
		}
	}

}
