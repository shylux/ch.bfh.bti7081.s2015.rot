package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import com.google.gson.annotations.Expose;

public class PhotoActivity extends Activity{

	/**
	 * maybe take a image specific datatype
	 */
	@Expose private Object image;
	

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
	public String getUrl(){ return "#!PhotoActivity/"+id;}
}
