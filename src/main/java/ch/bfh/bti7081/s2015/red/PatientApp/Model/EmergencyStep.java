package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import com.google.gson.annotations.Expose;

import ch.bfh.bti7081.s2015.red.PatientApp.Db.Persistable;

public class EmergencyStep implements Persistable
{
	@Expose private Contact contact;
	@Expose private String description;
	@Expose String id = "";
	@Expose String type = this.getClass().toString();

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
