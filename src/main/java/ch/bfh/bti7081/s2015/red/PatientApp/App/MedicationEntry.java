package ch.bfh.bti7081.s2015.red.PatientApp.App;

public class MedicationEntry extends CalendarEntry{

	public MedicationEntry()
	{

		display = "I think its disgusting and terrible how people treat Lance Armstrong, especially after winning 7 Tour de France Titles while on drugs!I can't even find my bike when I'm on drugs.";;
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
