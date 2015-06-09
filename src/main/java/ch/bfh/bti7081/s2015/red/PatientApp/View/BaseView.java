package ch.bfh.bti7081.s2015.red.PatientApp.View;


import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.ViewListener;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;


/**
 * Base Class for all Views
 * @author James Mayr
 * @author Stefan Tanner
 *
 * @param <T>
 */
public abstract class BaseView<T> extends VerticalLayout implements View<T>,com.vaadin.navigator.View{

	protected ArrayList<ViewListener> listeners=  new ArrayList<ViewListener>();
	
	/**
	 * add a new Presenter as listener to the list
	 * the presenter could later notifyed
	 */
	public void addListener(String name,ViewListener viewListener) {
		listeners.add(viewListener);
	}
	
	final protected String stringStartPage = "Hauptmenü";
	final protected Button buttonStartPage = new Button(stringStartPage);
	
	/**
	 * Add the startPage button to the current View
	 * 
	 * @return Component	returns the Button for the StartPageView
	 */
	protected Component addStartPageNavigation() {
		buttonStartPage.setWidth("300px");
		HorizontalLayout lineStartPageHolder = new HorizontalLayout();
		lineStartPageHolder.addComponent(buttonStartPage);
		return lineStartPageHolder;
	}
}