package ch.bfh.bti7081.s2015.red.PatientApp.Test;

import org.junit.Assert;
import org.junit.Test;

import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.GpsCoordinate;


public class TestGpsCoordinate {
	@Test
	public void TestCalcDistance()
	{
		
		GpsCoordinate point1 = new GpsCoordinate(10,10);
		GpsCoordinate point2 = new GpsCoordinate(10,10);
		
		Assert.assertEquals(0.0, point1.calcDistance(point2),0.1);
		
		
		//
		//Coordinates Gründerzentrum Bern: 46.9644149,7.4563786,266
		//Coordinates Migros Wankdorf: 46.965032,7.4633031
		//Expected: 529,9Meter
		GpsCoordinate gCenter = new GpsCoordinate(46.9644149,7.4563786);
		GpsCoordinate migors = new GpsCoordinate(46.965032,7.4633031);
		
		
		Assert.assertEquals(529.9, gCenter.calcDistance(migors),0.1);
		
		
	}
}
