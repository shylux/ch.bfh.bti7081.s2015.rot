package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.Db.MongoDbAdapter;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.GpsActivity;
import ch.bfh.bti7081.s2015.red.PatientApp.Presenter.ViewListener;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.Circle;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.GpsCoordinate;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.GpsLocationSimulator;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileResource;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapCircle;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapMarker;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

public class GpsActivityView extends BaseView<GpsActivity> implements Upload.Receiver, Upload.SucceededListener{


	GpsActivity activity;
	GpsCoordinate currentLocation = new GpsCoordinate(46.9644149,7.4563786);
	private Label distanceLabel 		= new Label("Distanz zum Ziel: ");
	private Label nameLabel				= new Label("Name: ");	
	private Label descriptionLabel		= new Label("Description: ");	
	private Label distance 				= new Label();
	private Label name					= new Label();	 
	private Label description 			= new Label();
	private Button walkForward 			= new Button("walk forward");
	private Button walkBackward		= new Button("walk backward");
	private Upload upload;
	private Image image = new Image();
	private GoogleMap googleMap;
	private GoogleMapMarker positionMarker;
	private GpsLocationSimulator gpsLocationSimulator;
	
	@Override
	public void buttonClick(ClickEvent event) { 
		
		// Navigate to startscreen
		if (event.getButton().getCaption().equals(stringStartPage)) { 
			getUI().getNavigator().navigateTo(NavigatorUI.STARTSCREEN);		
		}
		
		/*
		 * Marker must detached and attached again 
		 * otherwise the movement will not be recognize
		 */
		if(event.getSource() == walkForward)
		{
			currentLocation = gpsLocationSimulator.getNextOrLast();

		}
		else if(event.getSource() == walkBackward)
		{
			currentLocation = gpsLocationSimulator.getPreviousOrFirst();
			
		}
		
		if(activity.getCirlce().contains(currentLocation))
		{
			/*
			 * TODO: Insert GpsActivity Change here... 
			 */
			//load gpsActivity
			for(ViewListener listener: listeners)
			{
				listener.triggerEvent("enteredToTarget", activity);
			}
			
		}
		googleMap.removeMarker(positionMarker);
		positionMarker.setPosition(new LatLon(currentLocation.getLatitude(),currentLocation.getLongitude()));
		positionMarker.setAnimationEnabled(false);
		googleMap.addMarker(positionMarker);
		
		//update distance too
		distance.setValue(getFormatedDistance());

	}

	@Override
	public void update(GpsActivity model) 
	{
		this.removeAllComponents();
		activity = model;
		
		upload = new Upload("Bild hochladen", this);
		upload.addSucceededListener(this);
		image.setVisible(false);
		image.setWidth("300px");
		
		gpsLocationSimulator = new GpsLocationSimulator(this.currentLocation,activity.getCirlce().getCenter());
		gpsLocationSimulator.path(15);
		
		/*
		 * craete Google Map view
		 */
		googleMap = new GoogleMap(null,null,null);
		positionMarker = new GoogleMapMarker(
		            "Your Position", new LatLon(currentLocation.getLatitude(), currentLocation.getLongitude()),
		            true, null);
		positionMarker.setAnimationEnabled(false);
        googleMap.setCenter(new LatLon(currentLocation.getLatitude(), currentLocation.getLongitude()));
        googleMap.setZoom(16);
        googleMap.setSizeFull();
        googleMap.addMarker(positionMarker);
        
        Circle activityCircle = activity.getCirlce();
        GoogleMapCircle circle = new GoogleMapCircle();
        circle.setFillColor("#FF0000");
        circle.setFillOpacity(0.5);
        googleMap.setHeight("500px");
        googleMap.setWidth("300px");
        circle.setPosition(new LatLon(activityCircle.getCenter().getLatitude(),
        			activityCircle.getCenter().getLongitude()));
        circle.setRadius((int) activityCircle.getRadius());
        googleMap.addCircleOverlay(circle);
        
        HorizontalLayout line1 = new HorizontalLayout();
		HorizontalLayout line2 = new HorizontalLayout();
		VerticalLayout line25 = new VerticalLayout();
		HorizontalLayout line3 = new HorizontalLayout();
		HorizontalLayout line4 = new HorizontalLayout();
		
		line1.addComponent(nameLabel);
		name.setValue(activity.getShortName());
		description.setValue(activity.getDescription());
		line1.addComponent(name);
		line2.addComponent(descriptionLabel);
		line2.addComponent(description);
		line25.addComponent(upload);
		line25.addComponent(image);
		line4.addComponent(walkBackward);
		line4.addComponent(walkForward);
		
		walkBackward.addClickListener(this);
		walkForward.addClickListener(this);
	
		
		distance.setValue(getFormatedDistance());
		line3.addComponent(distanceLabel);
		line3.addComponent(distance);
		
		// add the default homescreen button
		this.addComponent(addStartPageNavigation());
		buttonStartPage.addClickListener(this);
		// end of adding default navigation
		
		this.addComponent(line1);
		this.addComponent(line2);
		this.addComponent(line25);
		this.addComponent(line3);
		this.addComponent(line4);
		this.addComponent(googleMap);
	}
	private String getFormatedDistance()
	{
		double calcDistance = activity.getDistance(currentLocation);
		DecimalFormat df = new DecimalFormat("#.#");
		
		if(Math.round(calcDistance) ==0)
			return "destination reached";
		return df.format(calcDistance)+" meters";
		 
		 
	}
	
	@Override
	public void update(ArrayList<GpsActivity> data) {
			
	}

	@Override
	public void enter(ViewChangeEvent event) {
		NavigatorUI.notificationThread.stopThread();
		
		//load gpsActivity
		for(ViewListener listener: listeners)
		{ 
			
			listener.triggerEvent("loadActivity", new GpsActivity(event.getParameters()));
			// listener.triggerEvent("loadActivity", activity);
		}

	}

	@Override
	public OutputStream receiveUpload(String filename, String mimetype) {
		try {
			this.activity.photo = File.createTempFile(filename, ".tmp");
			return new FileOutputStream(this.activity.photo);
		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("Can't create temp file for upload!");
			throw new RuntimeException("Can't create temp file for upload!");
		}
	}

	@Override
	public void uploadSucceeded(Upload.SucceededEvent succeededEvent) {
		new MongoDbAdapter().updateEntry(this.activity);
		image.setVisible(true);
		image.setSource(new FileResource(this.activity.photo));
	}
}

	
