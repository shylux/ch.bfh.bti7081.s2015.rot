package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import ch.bfh.bti7081.s2015.red.PatientApp.Db.Persistable;

public class EmergencyStep implements Persistable
{
	private Contact contact;
	private String description;
    String id = "";
    String type = this.getClass().toString();

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

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String _id) {
		this.id = _id;
	}
}
