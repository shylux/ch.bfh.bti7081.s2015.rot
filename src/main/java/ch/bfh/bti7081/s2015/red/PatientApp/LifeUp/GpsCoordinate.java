package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

import com.google.gson.annotations.Expose;

public class GpsCoordinate {

	/**
	 * radius of the earth in meters
	 */
	private static final int EARTH_RADIUS = 6371000;
	
	/**
	 * latitude component of a gps coordiante
	 */
	@Expose private double latitude;
	
	/**
	 * longitude component of a gps coordinate
	 */
	@Expose private double longitude;
	
	
	/**
	 * creates a new gps coordiante
	 * @param latitude
	 * @param longitude
	 */
	public GpsCoordinate(double latitude, double longitude)
	{
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * calculate the distance between an other gps coordinate
	 * return value is in meters
	 * @param other
	 * @return
	 */
	public double calcDistance(GpsCoordinate other)
	{
		double lat1 = degToRadian(this.latitude);
		double lng1 = degToRadian(this.longitude);
		double lat2 = degToRadian(other.latitude);
		double lng2 = degToRadian(other.longitude);
		
		/*
		 * use haversine Formula to calc the distance
		 * @see: http://en.wikipedia.org/wiki/Haversine_formula
		 */
		double inRootFormula = Math.sqrt(
				Math.sin((lat1 - lat2)/2)*Math.sin((lat1 - lat2)/2)+
				Math.cos(lat1)*Math.cos(lat2)*Math.sin((lng1-lng2)/2)*Math.sin((lng1-lng2)/2));
		
		return 2* EARTH_RADIUS * Math.asin(inRootFormula);

	
	}
	/**
	 * get latitude component of the gps coordiante
	 * @return
	 */
	public double getLatitude() {
		return latitude;
	}
	/**
	 * get longitude component of the gps coordinate
	 * @param latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	/**
	 * set the latitude component
	 * @return
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * set the longitude compononent
	 * @param longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	/**
	 * helper method that converts an degre angle into radian
	 * @param angle
	 * @return
	 */
	private double degToRadian(double angle)
	{
		return angle/180*Math.PI;
	}
	/**
	 * toString Method: usable for debuging/logging
	 */
	public String toString()
	{
		return Double.toString(latitude)+", "+Double.toString(longitude);
	}
}
