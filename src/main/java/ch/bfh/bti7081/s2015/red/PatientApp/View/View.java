package ch.bfh.bti7081.s2015.red.PatientApp.View;


import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Model;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.ViewListener;

import com.vaadin.ui.Button;

public interface View extends Button.ClickListener  
{
	/*
	 * add a new Viewlistener that the view could notiyfy
	 */
	public void addListener(ViewListener viewListener);
	/*
	 * (non-Javadoc)
	 * @see com.vaadin.ui.Button.ClickListener#buttonClick(com.vaadin.ui.Button.ClickEvent)
	 */
	public void buttonClick(Button.ClickEvent event);
	
	/*
	 * update a specific model
	 */
	public void update(Model model);

	/*
	 * update a collection of models
	 */
	public void update(ArrayList<Model> models);
}
