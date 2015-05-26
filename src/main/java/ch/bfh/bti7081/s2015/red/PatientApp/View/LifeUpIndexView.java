package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.VerticalLayout;

public class LifeUpIndexView extends BaseView <Activity>{

	private String strTitle 	= "LifeUp!";
	private String strToday		= "Heute";
	private String strTomorrow	= "Morgen";
	private String strOverview	= "Übersicht";
	
	final Button btnToday		= new Button(strToday);
	final Button btnTomorrow	= new Button(strTomorrow);
	final Button btnOverview	= new Button(strOverview);
	
	public LifeUpIndexView(){
		btnToday.addClickListener(this);
		btnTomorrow.addClickListener(this);
		btnOverview.addClickListener(this);		
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		String property = event.getButton().getCaption();
		
		if ( property.equals(strToday) ) {
			getUI().getNavigator().navigateTo(NavigatorUI.LIFEUPDETAIL); 
		}
		else if ( property.equals(strTomorrow) ) {
			getUI().getNavigator().navigateTo(NavigatorUI.LIFEUPDETAIL); 
		}
		else if ( property.equals(strOverview)){
			getUI().getNavigator().navigateTo(NavigatorUI.LIFEUPOVERVIEW);
		}
	}

	@Override
	public void update(Activity model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ArrayList<Activity> data) {

	}

	@Override
	public void enter(ViewChangeEvent event) {
		this.removeAllComponents();
		
		Label title = new Label(strTitle);
		title.addStyleName("h2");
		this.addComponent(title);
		
		String strButtonWidth = "200px";
		
		VerticalLayout buttonContainer	= new VerticalLayout();
		
		//HorizontalLayout lineTitle 		= new HorizontalLayout();
		HorizontalLayout lineToday 		= new HorizontalLayout();
		HorizontalLayout lineTomorrow 	= new HorizontalLayout();
		HorizontalLayout lineOverview	= new HorizontalLayout();
		
		lineToday.addComponent(btnToday);
		lineTomorrow.addComponent(btnTomorrow);
		lineOverview.addComponent(btnOverview);
		
		btnToday.setWidth(strButtonWidth);
		btnTomorrow.setWidth(strButtonWidth);
		btnOverview.setWidth(strButtonWidth);
		
		buttonContainer.addComponent(lineToday);
		buttonContainer.addComponent(lineTomorrow);		
		buttonContainer.addComponent(lineOverview);
		
		addComponent(buttonContainer);
	}
	
	
}
