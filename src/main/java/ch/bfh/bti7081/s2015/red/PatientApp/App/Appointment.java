package ch.bfh.bti7081.s2015.red.PatientApp.App;

public class Appointment extends CalendarEntry{

	private Contact contact = new Contact();
	
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
	@Override
	public String serialize() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deserialize(String json) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
