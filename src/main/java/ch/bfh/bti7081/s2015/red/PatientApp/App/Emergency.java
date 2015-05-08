package ch.bfh.bti7081.s2015.red.PatientApp.App;

import java.util.ArrayList;

public class Emergency {

	private ArrayList<EmergencyStep> steps = new ArrayList<EmergencyStep>();
	
	public ArrayList<EmergencyStep> getSteps() {
		return steps;
	}

	public void setSteps(ArrayList<EmergencyStep> steps) {
		this.steps = steps;
	}
}
