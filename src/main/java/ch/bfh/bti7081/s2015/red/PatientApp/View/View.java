package ch.bfh.bti7081.s2015.red.PatientApp.View;


import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.ViewListener;

import com.vaadin.ui.Button;


/**
 * Interface for all View Components
 * this Interface allow to notify all registred
 * presenters
 * @author James Mayr
 *
 * @param <T>
 */
public interface View <T> extends Button.ClickListener  
{
	/**
	 * add a new Viewlistener that the view could notiyfy
	 * @param name
	 * @param viewListener
	 */
	void addListener(String name, ViewListener viewListener);

	/**
	 * (non-Javadoc)
	 * @see com.vaadin.ui.Button.ClickListener#buttonClick(com.vaadin.ui.Button.ClickEvent)
	 */
	void buttonClick(Button.ClickEvent event);
	
	/**
	 * update a specific model
	 * @param model
	 */
	void update(T model);

	/**
	 * update a specific model
	 * @param models
	 */
	void update(ArrayList<T> data);
	
}