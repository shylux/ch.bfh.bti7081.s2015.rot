package ch.bfh.bti7081.s2015.red.PatientApp.Model;


import java.util.Date;

import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.Circle;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.GpsCoordinate;


public class GpsActivity extends Activity {

	private Circle circle;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDisplay(String data) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean checkSuccess() {
		// TODO Auto-generated method stub
		return false;
	}
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
