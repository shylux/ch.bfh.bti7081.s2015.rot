package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;
import ch.bfh.bti7081.s2015.red.PatientApp.lifeUp.LifeUp;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Link;
import com.vaadin.ui.Button.ClickEvent;

public class LifeUpOverviewView extends BaseView<LifeUp>{

	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(LifeUp model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ArrayList<LifeUp> data) {
		/*for(Activity activity : data)
		{
			this.addComponent(new Link(activity.getShortName(), new ExternalResource(activity.getUrl())));
		}*/
		
	}

}
