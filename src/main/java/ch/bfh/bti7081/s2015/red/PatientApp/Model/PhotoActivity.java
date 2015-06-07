package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import com.google.gson.annotations.Expose;

/**
 * this activty represents a photo based activity
 * the user must take a photo to fullfil this activity
 * @author James Mayr
 *
 */
public class PhotoActivity extends Activity{

	/**
	 * maybe take a image specific datatype
	 */
	@Expose private Object image;
	

	@Override
	public String display() {
		return null;
	}
	@Override
	public void setDisplay(String data) {
		
	}
	@Override
	public boolean checkSuccess() {
		return false;
	}
	public String getUrl(){ return "#!PhotoActivity/"+id;}
}
