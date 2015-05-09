package ch.bfh.bti7081.s2015.red.PatientApp.Model;

public class EmergencyStep
{
	private Contact contact;
	private String description;
	
	public EmergencyStep() {
		this("Hello World!");
	}
	public EmergencyStep(String desc)
	{
		this.description = desc;
	}
	public EmergencyStep(String desc, Contact cont)
	{
		this(desc);
		this.contact = cont;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	public Contact getContact()
	{
		return this.contact;
	}
}
