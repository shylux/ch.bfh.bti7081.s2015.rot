package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

import com.google.gson.annotations.Expose;

public class Circle extends Geofence{

	@Expose private GpsCoordinate center;
	@Expose private double radius;

	
	public Circle(GpsCoordinate center, double radius)
	{
		this.center = center;
		this.radius = radius;
	}
	public Circle(GpsCoordinate center)
	{
		this(center,20);
	}
	
	
	@Override
	public boolean contains(GpsCoordinate point) {
		return (center.calcDistance(point) < radius);
	}

	@Override
	public double getDistance(GpsCoordinate point) {
		return Math.max(center.calcDistance(point) - radius,0);
	}
	public GpsCoordinate getCenter() {
		return center;
	}
	public double getRadius() {
		return radius;
	}

}