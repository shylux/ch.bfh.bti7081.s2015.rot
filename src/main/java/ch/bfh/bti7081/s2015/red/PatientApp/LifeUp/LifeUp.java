package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public class LifeUp {
	static int levelGaps;
	int points;
	int currentLevel;
	
	ArrayList<Activity> activities = new ArrayList<Activity>();

	public static int getLevelGaps() {
		return levelGaps;
	}

	public static void setLevelGaps(int levelGaps) {
		LifeUp.levelGaps = levelGaps;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	public ArrayList<Activity> getActivities() {
		return activities;
	}

	public void setActivities(ArrayList<Activity> activities) {
		this.activities = activities;
	} 
	
	public String displayOverview(){
		return null;
	}
	
	public Activity getActivity (int number){
		return  null;
	}
}
