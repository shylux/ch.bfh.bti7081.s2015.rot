package ch.bfh.bti7081.s2015.red.PatientApp.lifeUp;

import com.google.gwt.core.client.Callback;
import com.google.gwt.geolocation.client.Position;
import com.google.gwt.geolocation.client.PositionError;

public class GeoLocationAdapter implements Callback<Position,PositionError> {

	@Override
	public void onFailure(PositionError reason) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onSuccess(Position result) {
		System.out.println(result);
		
	}

	
	
}
