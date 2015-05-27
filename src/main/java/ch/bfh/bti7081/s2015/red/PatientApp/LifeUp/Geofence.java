package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

public abstract class Geofence {

	public abstract boolean contains(GpsCoordinate point);
	public abstract double getDistance(GpsCoordinate point);
}
