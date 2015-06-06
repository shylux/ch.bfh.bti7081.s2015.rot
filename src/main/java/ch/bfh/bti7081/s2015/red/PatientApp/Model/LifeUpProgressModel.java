package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import java.util.ArrayList;

public class LifeUpProgressModel {
	
	private int initalPoints = 80;
	
	public ArrayList getProgressData() {
		
		ArrayList progressData = new ArrayList();
		int previousLimit = 0;
		progressData.add(0, initalPoints);
		
		for ( int i = 1; i < 100; i++ ) {
			int xpLimit =  (int) Math.pow(initalPoints, (1.0 + ((i + 2.0)/150.0))); 
			previousLimit = (int)progressData.get(i-1);
			progressData.add(i, xpLimit + previousLimit);
			xpLimit = initalPoints; 
		}

		return progressData;
	}
}
