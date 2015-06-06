package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

/**
 * just an inferface for geofences
 * e.g. circles, polygons and so on
 * @author James
 *
 */
public abstract class Geofence {

	/**
	 * check if a given gps coordinate is inside the geofence
	 * @param point
	 * @return
	 */
	public abstract boolean contains(GpsCoordinate point);
	
	/**
	 * calculate the shortest distance between a given 
	 * gps coordinate and the nearest geofence border
	 * @param point
	 * @return
	 */
	public abstract double getDistance(GpsCoordinate point);
}
