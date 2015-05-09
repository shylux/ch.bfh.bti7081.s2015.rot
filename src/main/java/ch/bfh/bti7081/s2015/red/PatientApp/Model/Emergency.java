package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import java.util.ArrayList;

public class Emergency {
	private ArrayList<EmergencyStep> steps = new ArrayList<EmergencyStep>();

	public Emergency() {
		steps.add(new EmergencyStep("Take a deep breath."));
		steps.add(new EmergencyStep("Yell at Neighbour."));
		steps.add(new EmergencyStep("Call your representative.",
									new Contact("Bin Laden", "+23 323 56 34")));
		steps.add(new EmergencyStep("Call Yoda",
									new Contact("Minch Yoda", "+12 345 67 89")));
	}
	
	public ArrayList<EmergencyStep> getSteps() {
		return steps;
	}

	public void setSteps(ArrayList<EmergencyStep> steps) {
		this.steps = steps;
	}
}
