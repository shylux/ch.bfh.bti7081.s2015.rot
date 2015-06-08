package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import com.google.gson.annotations.Expose;
/**
 * this class represents the logged in patient
 * @author James Mayr
 *
 */
public class Patient {

	/**
	 * first name of the patient
	 */
	@Expose private String firstName;
	
	/**
	 * patient's lastname
	 */
	@Expose private String lastName;
	
	/**
	 * display the patient data
	 * @return
	 */
	public String display()
	{
		return null;
	}
}
