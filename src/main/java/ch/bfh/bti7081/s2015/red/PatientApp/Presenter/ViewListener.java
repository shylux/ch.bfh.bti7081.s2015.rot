package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;

import java.util.ArrayList;


/**
 * 
 * an interface for presenters
 * 
 * @author James Mayr
 *
 * @param <T>
 */
public interface ViewListener<T> {
	
	/**
	 * notify a button click to the presenter
	 * @param property name of the button
	 * @param data data e.g. specific model
	 */
	void buttonClick(String property, T data);
	
	/**
	 * notify a button click to the presenter
	 * @param property
	 * @param data
	 */
	void buttonClick(String property, ArrayList<T> data);
	
	/**
	 * notify other events to the presenter (e.g. Time is up)
	 * @param event event name
	 * @param data data e.g. specific model
	 */
	void triggerEvent(String event, T data);
}
