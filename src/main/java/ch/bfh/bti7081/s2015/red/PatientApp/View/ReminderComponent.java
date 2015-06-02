package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.CalendarEntry;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;

public class ReminderComponent extends CustomComponent {

	public ReminderComponent(ArrayList<CalendarEntry> entries)
	{
		this.setStyleName("custom-reminder-comp");
		Label title = new Label("");
		title.setCaption("Things to do");
		this.setCompositionRoot(title);
		for(CalendarEntry entry: entries)
		{
			String linkText = entry.getShortName();
			this.setCompositionRoot(new Link(linkText,new ExternalResource(entry.getUrl())));
		}
	}
}
