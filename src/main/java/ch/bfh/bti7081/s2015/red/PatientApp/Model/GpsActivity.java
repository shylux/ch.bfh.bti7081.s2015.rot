package ch.bfh.bti7081.s2015.red.PatientApp.Model;

public class GpsActivity extends Activity {

	private double latitude;
	private double longitude;

	@Override
	public String display() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDisplay(String data) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean checkSuccess() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void setLatLn(double lat,double lng)
	{
		this.latitude = lat;
		this.longitude = lng;
	}
	public double getLat(double lat)
	{
		return latitude;
	}
	public double getLng(double lng)
	{
		return longitude;
	}

}
