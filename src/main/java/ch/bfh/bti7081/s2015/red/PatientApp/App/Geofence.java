package ch.bfh.bti7081.s2015.red.PatientApp.App;

public abstract class Geofence {

	public abstract boolean contains(double latitude, double longitude);
	public abstract double getDistance(double latitude, double longitude);
}
