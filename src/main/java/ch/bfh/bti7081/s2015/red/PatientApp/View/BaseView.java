package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;
import java.util.HashMap;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Model;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.ViewListener;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public abstract class BaseView extends VerticalLayout implements View{

	protected HashMap<String,ViewListener> listeners=  new HashMap<String,ViewListener>();

	@Override
	public void addListener(String name,ViewListener viewListener) {
		listeners.put(name,viewListener);
		
	}
	
	/**
	 * 
	 */
	public void beforeRender()
	{
		for(ViewListener listener : listeners.values())
			listener.init(null);
	}
		
}