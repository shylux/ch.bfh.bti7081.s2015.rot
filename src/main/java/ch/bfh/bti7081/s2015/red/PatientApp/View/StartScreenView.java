package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.App.CalendarEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.ViewListener;

import com.google.gwt.layout.client.Layout;
import com.google.gwt.thirdparty.guava.common.collect.Multiset.Entry;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;



public class StartScreenView extends  BaseView<CalendarEntry> implements View<CalendarEntry>, com.vaadin.navigator.View{

	
	ArrayList<CalendarEntry> collection = new ArrayList<>();
	
	public StartScreenView()
	{
		Label label = new Label("Start Page");

		addComponent(label);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
		final TextField tf1 = new TextField("TextField",collection.get(0).display());
		final TextField tf2 = new TextField("TextField",collection.get(1).display());
		addComponent(tf1);
		addComponent(tf2);
		
		Notification.show("You're welcome");
		
		Button button = new Button("Click Me");
		addComponent(button);
		button.addClickListener(new Button.ClickListener() {
	      @Override
	      public void buttonClick(ClickEvent event) {
	         getUI().getNavigator().navigateTo(NavigatorUI.MEDICATIONINDEX);
		      }
		  });
		Button button1 = new Button("Update data");
		addComponent(button1);
		button1.addClickListener(new Button.ClickListener() {
		      @Override
		      public void buttonClick(ClickEvent event) {
		    	  
		    	  collection.get(0).setDisplay(tf1.getValue());
		    	  collection.get(1).setDisplay(tf2.getValue());
		   
		         for(ViewListener listener: listeners)
		         {
		        	 
		        	 listener.buttonClick("UPDATE",collection);
			     }
		      }
			  });
		
		
		
	}

	@Override
	public void update(CalendarEntry model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ArrayList<CalendarEntry> data) {
		collection =data;
		
	}

}
