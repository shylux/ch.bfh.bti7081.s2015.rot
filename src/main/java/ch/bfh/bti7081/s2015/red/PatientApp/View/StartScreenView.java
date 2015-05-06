package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Model;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.MedicationIndexPresenter;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.StartPagePresenter;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;



public class StartScreenView extends BaseView implements View, com.vaadin.navigator.View{

	
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
	public void update(Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ArrayList<Model> models) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
	
		
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

}
