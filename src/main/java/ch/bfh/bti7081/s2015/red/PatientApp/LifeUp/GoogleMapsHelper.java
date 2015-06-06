package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;


/**
 * provides helper methods for calculating
 * map center and zoom
 * @author James Mayr
 *
 */
public class GoogleMapsHelper {
	
	/**
	 * scale of the zoom level in meters per pixel
	 * @see: https://msdn.microsoft.com/en-us/library/aa940990.aspx
	 */
	private static double[] zoomLevelScale = new double[]
			{
		21282,
		16355,
		10064,
		5540,
		2909,
		1485,
		752,
		378,
		190,
		95,
		48,
		24,
		12,
		6,
		3,
		1.48,
		0.74,
		0.37,
		0.19
			};
	public static GpsCoordinate calcMapCenter(GpsCoordinate location, GpsCoordinate point)
	{
		GpsLocationSimulator simulator = new GpsLocationSimulator(location,point);
		return simulator.path(2).get(0);
	}
	public static int calcZoomLevel(GpsCoordinate location, GpsCoordinate point, int width, int height)
	{
		/**
		 * @see: https://msdn.microsoft.com/en-us/library/bb259689.aspx
		 */
		
		//Calc lat  distance
		GpsCoordinate latCalc = new GpsCoordinate(point.getLatitude(),location.getLongitude());
		double latDistance = latCalc.calcDistance(location);
		
		//calc long distance
		GpsCoordinate lngCalc = new GpsCoordinate(location.getLatitude(),point.getLongitude());
		double lngDistance = lngCalc.calcDistance(location);
		
		for(int i = zoomLevelScale.length-1; i > 0; i--)
		{
			if(zoomLevelScale[i]*width > lngDistance && zoomLevelScale[i]*height > latDistance)
				return i+1;
		}
		return 1;
	}
}
