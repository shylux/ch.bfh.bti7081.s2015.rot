package ch.bfh.bti7081.s2015.red.PatientApp.View;

import ch.bfh.bti7081.s2015.red.PatientApp.App.EmergencyStep;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class EmergencyStepComponent extends CustomComponent {
	public EmergencyStepComponent(EmergencyStep emergStep) {
		Panel panel = new Panel();
		VerticalLayout content = new VerticalLayout();
		content.addComponent(new Label(emergStep.getDescription()));
		if (emergStep.getContact() != null)
			content.addComponent(new ContactComponent(emergStep.getContact()));
		panel.setContent(content);
		this.setCompositionRoot(panel);
	}
}
