package ch.bfh.bti7081.s2015.red.PatientApp.Model;


import java.util.Date;

import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.Circle;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.GpsCoordinate;

import com.google.gson.annotations.Expose;


/**
 * this class represents a gps based activity
 * @author James
 *
 */
public class GpsActivity extends Activity {

	/**
	 * a circle with the gps position of activity that must be 
	 * reached to fullfil the activity
	 */
	@Expose private Circle circle;

	public GpsActivity(){}
	public GpsActivity(String id){super(id);}
	public GpsActivity(String shortName,String description,Circle circle)
	{
		super(shortName,description);
		this.circle = circle;
	}
	public GpsActivity(String shortName,String description,Circle circle,Date start,Date end)
	{
		super(shortName,description,start,end);
		this.circle = circle;
	}
	
	@Override
	public String display() {
		return null;
	}

	@Override
	public void setDisplay(String data) {
		
	}
	@Override
	public boolean checkSuccess() {

		return false;
	}
	/**
	 * caclulate the distance between the gps activity 
	 * and a given gps coordinate e.g user's current location
	 * @param coordinate
	 * @return
	 */
	public double getDistance(GpsCoordinate coordinate)
	{
		return this.circle.getDistance(coordinate);
	}
	public Circle getCirlce()
	{
		return this.circle;
	}
	public String getUrl(){ return "#!GpsActivity/"+id;}

}
