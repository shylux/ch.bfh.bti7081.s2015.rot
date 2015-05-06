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

	protected HashMap<String,ViewListener> listener=  new HashMap<String,ViewListener>();

	@Override
	public void addListener(String name,ViewListener viewListener) {
		listener.put(name,viewListener);
		
	}


	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Model model) {
		// TODO Auto-generated method stub
		
	}

		
	}
