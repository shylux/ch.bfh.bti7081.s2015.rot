package ch.bfh.bti7081.s2015.red.PatientApp.Test;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.Assert;

import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.GpsCoordinate;
import ch.bfh.bti7081.s2015.red.PatientApp.LifeUp.GpsLocationSimulator;

public class TestGpsLocationSimulator {

	@Test
	public void TestGpsPaths()
	{
		GpsCoordinate start = new GpsCoordinate(46.9644149,7.4563786);
		GpsCoordinate destination = new GpsCoordinate(46.965032,7.4633031);
		
		GpsLocationSimulator simulator = new GpsLocationSimulator(start, destination);
		
		int steps = 100;
		ArrayList<GpsCoordinate> path = simulator.path(steps);
		
		
		Assert.assertEquals(steps, path.size());
		GpsCoordinate lastPosition = null;
		for(int i =0; i < steps; i++)
		{
			if(i!=0)
			{
				lastPosition = path.get(i-1);
				boolean isNearer = lastPosition.calcDistance(destination) > path.get(i).calcDistance(destination);
				Assert.assertEquals(true, isNearer);
			}
		}
		Assert.assertEquals(0.0,path.get(steps-1).calcDistance(destination),0.1);
		
	}
}