package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.bti7081.s2015.red.PatientApp.Db.MongoDbAdapter;
import ch.bfh.bti7081.s2015.red.PatientApp.Db.Persistable;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Emergency;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.EmergencyStep;

public class EmergencyView extends BaseView<Emergency> {
	
	List<EmergencyStep> emergSteps = new ArrayList<EmergencyStep>();
	
	public EmergencyView()
	{
		super();
		Label label = new Label("Emergency");
        addComponent(label);
	}

	@Override
	public void buttonClick(ClickEvent event) {}

	@Override
	public void update(Emergency model) {
	
		MongoDbAdapter adapter = new MongoDbAdapter();
		adapter.insertIntoDatabase(model);
		ArrayList<Persistable> data = adapter.getSpecificCollection(model);
		
		for (EmergencyStep emergStep: model.getSteps())
		{
			addComponent(new EmergencyStepComponent(emergStep));

		}

	}

	@Override
	public void update(ArrayList<Emergency> data) {}

	@Override
	public void enter(ViewChangeEvent event) {}

}
