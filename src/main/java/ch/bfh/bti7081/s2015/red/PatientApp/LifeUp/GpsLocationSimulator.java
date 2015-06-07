package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

import java.util.ArrayList;


import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;



/**
 * this class simulates a gps location
 * it provies a path of gps coordinates form a given start point 
 * to a specific destination. 
 * it uses only an approximation (works only for short distances)
 * 
 * @author James Mayr
 *
 */
public class GpsLocationSimulator {

	/**
	 * gps coordinate start point
	 */
	private GpsCoordinate start;
	
	/**
	 * end position of the path
	 */
	private GpsCoordinate end;
	
	/**
	 * current gps coordinate 
	 */
	private GpsCoordinate currentPos;
	
	/**
	 * all calculated gps coordinates of the path are stored here
	 */
	private ArrayList<GpsCoordinate>path;
	
	/**
	 * the current position in the path-array
	 */
	private int currentPosition = -1;
	
	
	/**
	 * create a new gps location simulator
	 * @param start
	 * @param end
	 */
	public GpsLocationSimulator(GpsCoordinate start,GpsCoordinate end)
	{
		this.start = start;
		this.end = end;
	}
	
	/**
	 * calculate the a path between a start point and an end point
	 * 
	 * @param steps numbers of steps in the path
	 * @return calculated path
	 */
	public ArrayList<GpsCoordinate> path(int steps)
	{
		
		path = new ArrayList<>();
		Vector2D startVector = toVector(start);
		Vector2D endVector = toVector(end);
		
		Vector2D direction = endVector.subtract(startVector);
		direction = direction.scalarMultiply(1.0/steps);
		for(int i = 0; i < steps; i++)
		{
			startVector = startVector.add(direction);
			path.add(toGpsCoordinate(startVector));
		}
		return path;
		
	}
	
	/**
	 * helper method that converts a gps coordinate into a vector
	 * @param point
	 * @return
	 */
	private Vector2D toVector(GpsCoordinate point)
	{
		double lat = point.getLatitude();
		double lng = point.getLongitude();
		lat =lat/180*Math.PI;
		lng =lng/180*Math.PI;
		
		double xPoint = Math.cos(lng);
		double yPoint = Math.sin(lat);
		return new Vector2D(xPoint,yPoint);
	}
	/**
	 * helper method that converts a vector into a gps coordiante
	 * @param position
	 * @return
	 */
	private GpsCoordinate toGpsCoordinate(Vector2D position)
	{
		double lat = Math.asin(position.getY());
		double lng = Math.acos(position.getX());

		
		lat =lat*180/Math.PI;
		lng = lng*180/Math.PI;
		
		return new GpsCoordinate(lat,lng);
	
	}
	
	/**
	 * get the next path or last position in the cacluated path
	 * @return null if path is empty
	 */
	public GpsCoordinate getNextOrLast()
	{
		if(path == null || path.size() ==0)return null;
		if(currentPosition+1 >= path.size())
		{
			return path.get(path.size()-1);
		}
		return path.get(++currentPosition);
			
	}
	
	/**
	 * get the previous or first position in the calculated path
	 * @return null if path is empty
	 */
	public GpsCoordinate getPreviousOrFirst()
	{
		if(path == null || path.size() ==0)return null;
		if(currentPosition-1 < 0)
		{
			return path.get(0);
		}
		return path.get(--currentPosition);
	}
	
}