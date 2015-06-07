package ch.bfh.bti7081.s2015.red.PatientApp.Test;

import java.util.ArrayList;

import org.junit.Test;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.LifeUpProgressModel;
import junit.framework.Assert; 

public class TestProgressSystem {
	
	@Test
	public void checkLevelSystem() 
	{
		LifeUpProgressModel progress = new LifeUpProgressModel();
		ArrayList progressData = progress.getProgressData();
		
		Assert.assertEquals(100, progressData.size());
		
		for ( int i = 0; i < progressData.size() - 1; i++ ) {
			Assert.assertTrue((int)progressData.get(i) < (int)progressData.get(i+1));
		}
		
		int currentLevel = 25;
		int currentPoints = (int) progressData.get(currentLevel);
		int neededPoints = (int) progressData.get(currentLevel+1);
		int difference = neededPoints - currentPoints;
		
		currentPoints += difference -1;
		 
		Assert.assertTrue(currentPoints > (int)progressData.get(currentLevel) && currentPoints < (int)progressData.get(currentLevel+1) );
		currentPoints++;
		
		Assert.assertTrue((int)progressData.get(currentLevel+1) == currentPoints);
		
	}
}
