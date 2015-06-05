package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.MedicationEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.ViewListener;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
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
		medication = medicatonEntry;
		addComponent(new Label("Medikation"));
		// Set Layout
		VerticalLayout content = new VerticalLayout();
		content.addComponent(new Label(medication.getName()));
		content.addComponent(new Label(medication.getDescription()));
		content.addComponent(new Label(medication.getHowMuchADay()));
		content.addComponent(new Label(medication.getName()));
		
		for(String times : medication.getTimes()){
			content.addComponent(new Label(times));
		}
		
		addComponent(content);
	}

	@Override
	public void update(ArrayList<MedicationEntry> data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		for(ViewListener<MedicationEntry> listener: listeners)
		{
			listener.triggerEvent("loadActivity", new MedicationEntry(event.getParameters()));
		}
	}

}
