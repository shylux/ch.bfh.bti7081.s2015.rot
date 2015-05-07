package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;
import java.util.HashMap;

import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.ViewListener;

import com.vaadin.ui.VerticalLayout;

public abstract class BaseView<T> extends VerticalLayout implements View<T>{

	protected ArrayList<ViewListener> listeners=  new ArrayList<ViewListener>();

	
	
	@Override
	public void addListener(String name,ViewListener viewListener) {
		viewListener.init(null);
		listeners.add(viewListener);
		
	}
			
}