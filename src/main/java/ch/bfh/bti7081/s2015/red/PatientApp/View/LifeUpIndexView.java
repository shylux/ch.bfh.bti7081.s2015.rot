package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;

public class LifeUpIndexView extends BaseView <Activity>{

	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Activity model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ArrayList<Activity> data) {
		Label title = new Label("Activities todo");
		title.addStyleName("h2");
		this.addComponent(title);
		for(Activity activity : data)
		{
			this.addComponent(new Link(activity.getShortName(), new ExternalResource(activity.getUrl())));
		}
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
