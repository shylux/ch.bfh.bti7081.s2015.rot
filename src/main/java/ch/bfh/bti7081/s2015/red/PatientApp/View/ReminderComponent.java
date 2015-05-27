package ch.bfh.bti7081.s2015.red.PatientApp.View;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;

public class ReminderComponent extends CustomComponent {

	public ReminderComponent()
	{
		this.setCompositionRoot(new Label("test"));
		this.setStyleName("custom-reminder-comp");
	}

}
