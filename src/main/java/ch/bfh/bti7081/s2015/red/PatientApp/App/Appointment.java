package ch.bfh.bti7081.s2015.red.PatientApp.App;

public class Appointment extends CalendarEntry{

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

}
