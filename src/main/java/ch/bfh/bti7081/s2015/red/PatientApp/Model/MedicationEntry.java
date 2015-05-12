package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import java.util.ArrayList;

public class MedicationEntry extends CalendarEntry{
	
	private String name = "";
	private String description = "";
	private String howMuchADay = "";
	private String howToTake = "";
	private ArrayList<String> tmp = new ArrayList<String>();
	
	public MedicationEntry(String name, String description, String howMuchADay, String howToTake, ArrayList<String> tmp) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.description = description;
		this.howMuchADay = howMuchADay;
		this.howToTake = howToTake;
		this.tmp = tmp;
	}
	
	public MedicationEntry()
	{
		this.name = "mediname";
		this.description = "medidescription";
		this.howMuchADay = "howMuchADay";
		this.howToTake = "howToTake";
		tmp.add("what a tmp");
		this.tmp = tmp;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHowMuchADay() {
		return howMuchADay;
	}

	public void setHowMuchADay(String howMuchADay) {
		this.howMuchADay = howMuchADay;
	}

	public String getHowToTake() {
		return howToTake;
	}

	public void setHowToTake(String howToTake) {
		this.howToTake = howToTake;
	}

	public ArrayList<String> getTmp() {
		return tmp;
	}

	public void setTmp(ArrayList<String> tmp) {
		this.tmp = tmp;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
