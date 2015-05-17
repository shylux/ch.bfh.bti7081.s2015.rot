package ch.bfh.bti7081.s2015.red.PatientApp.App;

public class GpsCoordinate {

	private static final int EARTH_RADIUS = 6371000;
	
	private double latitude;
	private double longitude;
	public GpsCoordinate(double latitude, double longitude)
	{
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double calcDistance(GpsCoordinate other)
	{
		double lat1 = degToRadian(this.latitude);
		double lng1 = degToRadian(this.longitude);
		double lat2 = degToRadian(other.latitude);
		double lng2 = degToRadian(other.longitude);
		
		/*
		 * use haversine Formula to calc the distance
		 * @see: http://en.wikipedia.org/wiki/Haversine_formula
		 */
		double inRootFormula = Math.sqrt(
				Math.sin((lat1 - lat2)/2)*Math.sin((lat1 - lat2)/2)+
				Math.cos(lat1)*Math.cos(lat2)*Math.sin((lng1-lng2)/2)*Math.sin((lng1-lng2)/2));
		
		return 2* EARTH_RADIUS * Math.asin(inRootFormula);

	
	}
	/* getter and setter
	 * 
	 */
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	private double degToRadian(double angle)
	{
		return angle/180*Math.PI;
	}
	
}
