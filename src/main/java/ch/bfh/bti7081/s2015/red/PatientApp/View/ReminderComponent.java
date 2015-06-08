package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.CalendarEntry;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 * an overlay component for notifications
 * @author James Mayr
 *
 */
public class ReminderComponent extends CustomComponent {

	public ReminderComponent(ArrayList<CalendarEntry> entries)
	{
		
		this.setStyleName("custom-reminder-comp");
		Label title = new Label("Things to do");
		title.setStyleName("custom-reminder-title");
		
		
		Panel panel = new Panel();
		
		
		VerticalLayout content = new VerticalLayout();
		content.addComponent(title);
		

		//add all notifications
		for(CalendarEntry entry: entries)
		{
			String linkText = entry.getShortName();
			content.addComponent(new Link(linkText,new ExternalResource(entry.getUrl())));
		}
		
		this.setCompositionRoot(content);
	}
}
