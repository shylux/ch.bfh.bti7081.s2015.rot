package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

import java.util.ArrayList;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;


/**
 * this class simulates a gps location
 * it provies a path of gps coordinates form a given start point 
 * to a specific destination. it uses only an approximation (works only for short distances)
 * 
 * @author James Mayr
 *
 */
public class GpsLocationSimulator {

	private GpsCoordinate start;
	private GpsCoordinate end;
	private GpsCoordinate currentPos;
	private ArrayList<GpsCoordinate>path;
	private int currentPosition = -1;
	
	public GpsLocationSimulator(GpsCoordinate start,GpsCoordinate end)
	{
		this.start = start;
		this.end = end;
	}
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
	private GpsCoordinate toGpsCoordinate(Vector2D position)
	{
		double lat = Math.asin(position.getY());
		double lng = Math.acos(position.getX());

		
		lat =lat*180/Math.PI;
		lng = lng*180/Math.PI;
		
		return new GpsCoordinate(lat,lng);
	
	}
	public GpsCoordinate getNextOrLast()
	{
		if(path == null || path.size() ==0)return null;
		if(currentPosition+1 >= path.size())
		{
			return path.get(path.size()-1);
		}
		return path.get(++currentPosition);
			
	}
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