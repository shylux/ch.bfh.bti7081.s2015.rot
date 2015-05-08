package ch.bfh.bti7081.s2015.red.PatientApp.View;

import ch.bfh.bti7081.s2015.red.PatientApp.App.Contact;

import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class ContactComponent extends CustomComponent {

	public ContactComponent(Contact contact)
	{
		Panel panel = new Panel();
		HorizontalLayout content = new HorizontalLayout();
		content.addComponent(new Label(contact.getName()));
		content.addComponent(new Link(contact.getPhone_number(), null));
		panel.setContent(content);
		this.setCompositionRoot(panel);
	}
}
