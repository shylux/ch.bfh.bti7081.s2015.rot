package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import com.google.gson.annotations.Expose;

public class Appointment extends CalendarEntry{

	@Expose private Contact contact = new Contact("Minch Yoda", "+12 345 67 89");
	
	public Appointment()
	{
		
		display = "A wizard is never late, nor is he early, he arrives precisely when he means to";
	}
	@Override
	public String display() {
		return display;
	
	}

	@Override
	public void setDisplay(String data) {
		display = data;
		
	}
	public String getUrl(){ return "#!Appointment/"+id;}
}

