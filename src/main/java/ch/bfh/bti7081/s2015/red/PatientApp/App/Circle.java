package ch.bfh.bti7081.s2015.red.PatientApp.App;

public class Circle extends Geofence{

	private GpsCoordinate center;
	private double radius;
	
	public Circle(GpsCoordinate center, double radius)
	{
		this.center = center;
		this.radius = radius;
	}
	
	
	@Override
	public boolean contains(GpsCoordinate point) {
		return (center.calcDistance(point) < radius);
	}

	@Override
	public double getDistance(GpsCoordinate point) {
		return Math.max(center.calcDistance(point) - radius,0);
	}

}
