package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.ViewListener;

import com.vaadin.ui.VerticalLayout;


/**
 * Base Class for all Views
 * @author James Mayr
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
			
}