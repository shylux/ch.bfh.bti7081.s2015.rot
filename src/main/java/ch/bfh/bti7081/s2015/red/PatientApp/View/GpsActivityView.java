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
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapCircle;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapMarker;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.JavaScriptFunction;
import com.vaadin.ui.Label;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Emergency;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.GpsActivity;
import ch.bfh.bti7081.s2015.red.PatientApp.lifeUp.Circle;
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
	private GoogleMap googleMap;
	private GoogleMapMarker positionMarker;
	
	@Override
	public void buttonClick(ClickEvent event) {
		
	}

	@Override
	public void update(GpsActivity model) {
		
		activity = model;
		googleMap = new GoogleMap(null,null,null);

		positionMarker = new GoogleMapMarker(
		            "Your Position", new LatLon(currentLocation.getLatitude(), currentLocation.getLongitude()),
		            true, null);
		
        googleMap.setCenter(new LatLon(currentLocation.getLatitude(), currentLocation.getLongitude()));
        googleMap.setZoom(17);
        googleMap.setSizeFull();
        googleMap.addMarker(positionMarker);
        Circle activityCircle = activity.getCirlce();
        GoogleMapCircle circle = new GoogleMapCircle();
        circle.setFillColor("#FF0000");
        circle.setFillOpacity(0.5);
        googleMap.setHeight("700px");
        circle.setPosition(new LatLon(activityCircle.getCenter().getLatitude(),
        			activityCircle.getCenter().getLongitude()));
        circle.setRadius((int) activityCircle.getRadius()*10);
        googleMap.addCircleOverlay(circle);
        
		
		
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
		this.addComponent(googleMap);
		
		
		
	}
	@Override
	public void update(ArrayList<GpsActivity> data) {
			
	}

	@Override
	public void enter(ViewChangeEvent event) {
	
		
	}
}

	
