package ch.bfh.bti7081.s2015.red.PatientApp.View;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Contact;
import com.vaadin.ui.*;

/**
 * Renders a contact.
 * Intended to be used in a view or another component.
 */
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
