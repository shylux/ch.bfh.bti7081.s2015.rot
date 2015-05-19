package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.text.DecimalFormat;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gwt.core.client.Callback;
import com.google.gwt.geolocation.client.Geolocation;
import com.google.gwt.geolocation.client.Position;
import com.google.gwt.geolocation.client.PositionError;



import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Page;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.JavaScriptFunction;
import com.vaadin.ui.Label;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Emergency;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.GpsActivity;
import ch.bfh.bti7081.s2015.red.PatientApp.lifeUp.GpsCoordinate;

public class GpsActivityView extends BaseView<GpsActivity>{

	GpsActivity activity;
	GpsCoordinate currentLocation = new GpsCoordinate(46.9644149,7.4563786);
	private Label distanceLabel 		= new Label("Distanz zum Ziel: ");
	private Label nameLabel				= new Label("Name: ");	
	private Label descriptionLabel		= new Label("Description: ");	
	private Label distance 				= new Label();
	private Label name					= new Label();	 
	private Label description 			= new Label();
	
	@Override
	public void buttonClick(ClickEvent event) {
		
	}

	@Override
	public void update(GpsActivity model) {
		activity = model;
		HorizontalLayout line1 = new HorizontalLayout();
		HorizontalLayout line2 = new HorizontalLayout();
		HorizontalLayout line3 = new HorizontalLayout();
		
		line1.addComponent(nameLabel);
		name.setValue(activity.getShortName());
		description.setValue(activity.getDescription());
		line1.addComponent(name);
		line2.addComponent(descriptionLabel);
		line2.addComponent(description);
		
		double calcDistance = activity.getDistance(currentLocation);
		 DecimalFormat df = new DecimalFormat("#.#");
		distance.setValue(df.format(calcDistance)+" meters");
		line3.addComponent(distanceLabel);
		line3.addComponent(distance);
		this.addComponent(line1);
		this.addComponent(line2);
		this.addComponent(line3);
		
		
		
	}
	@Override
	public void update(ArrayList<GpsActivity> data) {
			
	}

	@Override
	public void enter(ViewChangeEvent event) {
	
		
	}
}

	
