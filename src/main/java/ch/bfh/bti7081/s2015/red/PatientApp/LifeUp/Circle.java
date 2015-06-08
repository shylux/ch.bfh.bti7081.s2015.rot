package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

import com.google.gson.annotations.Expose;

/**
 * this class represents a circle 
 * with a specific gps coordinate
 * @author James Mayr
 *
 */
public class Circle extends Geofence{

	/**
	 * the gps position of the circle
	 */
	@Expose private GpsCoordinate center;
	
	/**
	 * circle radius
	 */
	@Expose private double radius;

	
	/**
	 * create a new Circle
	 * @param center the gps coordinate of the circle
	 * @param radius circle radius
	 */
	public Circle(GpsCoordinate center, double radius)
	{
		this.center = center;
		this.radius = radius;
	}
	
	/**
	 * creates a circle with default radius (20m)
	 * @param center
	 */
	public Circle(GpsCoordinate center)
	{
		this(center,20);
	}
	
	/**
	 * check if a given gps is inside of 
	 * the circle
	 */
	@Override
	public boolean contains(GpsCoordinate point) {
		return (center.calcDistance(point) < radius);
	}

	/**
	 * caculate the distance between the circle border and a given point
	 */
	@Override
	public double getDistance(GpsCoordinate point) {
		return Math.max(center.calcDistance(point) - radius,0);
	}
	/**
	 * get the gps coordiante of the circle
	 * @return
	 */
	public GpsCoordinate getCenter() {
		return center;
	}
	
	/**
	 * get the radius of the circle
	 * @return
	 */
	public double getRadius() {
		return radius;
	}

}