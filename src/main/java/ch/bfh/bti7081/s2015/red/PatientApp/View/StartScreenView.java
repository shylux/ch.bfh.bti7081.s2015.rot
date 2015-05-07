package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.App.CalendarEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.ViewListener;

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
	
		
		for(CalendarEntry entry: collection)
		{
			Label tf = new Label(entry.display());
			addComponent(tf);
		}
		
		Notification.show("You're welcome");
		
		Button button = new Button("Click Me");
		addComponent(button);
		button.addClickListener(new Button.ClickListener() {
	      @Override
	      public void buttonClick(ClickEvent event) {
	         getUI().getNavigator().navigateTo(NavigatorUI.MEDICATIONINDEX);
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
