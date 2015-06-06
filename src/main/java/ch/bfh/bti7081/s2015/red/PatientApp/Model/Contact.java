package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import com.google.gson.annotations.Expose;

/**
 * A contact of the patient related to his addiction.
 * Eg. a therapist, a doctor or a close friend.
 */
public class Contact {
	@Expose private String name;
	@Expose private String phone_number;

	public Contact(String _name, String _phone_number)
	{
		this.name = _name;
		this.phone_number = _phone_number;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
}
