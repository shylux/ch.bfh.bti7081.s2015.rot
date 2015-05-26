package ch.bfh.bti7081.s2015.red.PatientApp.Test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import ch.bfh.bti7081.s2015.red.PatientApp.Db.MongoDbAdapter;
import ch.bfh.bti7081.s2015.red.PatientApp.Db.Persistable;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Appointment;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.CalendarEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Emergency;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.EmergencyStep;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.MedicationEntry;

public class TestMongoDbAdapter {

	@Test
	public void testInsertAndGetSingleObject()
	{
		MongoDbAdapter adapter = new MongoDbAdapter();
		adapter.erase();
		Appointment app = new Appointment();
		
		adapter.insertIntoDatabase(app);
		
		Persistable persistable = adapter.getEntryFromDatabase(app);
		
		Assert.assertEquals( app.serialize(),persistable.serialize());
	
	}
	@Test
	public void testGetSpecificCollection()
	{
		MongoDbAdapter adapter = new MongoDbAdapter();
		adapter.erase();
		
		ArrayList<Persistable> persistables = new ArrayList<>();
		persistables.add(new Appointment());
		persistables.add(new Appointment());
		persistables.add(new Appointment());
		
		persistables.add(new Emergency());
		persistables.add(new MedicationEntry());
		persistables.add(new MedicationEntry());
		
		
		adapter.insertIntoDatabase(persistables);
		
		ArrayList<Persistable> listFromDb = adapter.getSpecificCollection(Appointment.class);
		Assert.assertEquals(3,listFromDb.size());
		Assert.assertEquals(new Appointment().getClass(),listFromDb.get(0).getClass());
		Assert.assertEquals(new Appointment().getClass(),listFromDb.get(1).getClass());
		Assert.assertEquals(new Appointment().getClass(),listFromDb.get(2).getClass());
	
	}
	@Test
	public void testGetSpecificCollectionWithSubtypes()
	{
		MongoDbAdapter adapter = new MongoDbAdapter();
		adapter.erase();
		
		ArrayList<Persistable> persistables = new ArrayList<>();
		persistables.add(new Appointment());
		persistables.add(new Appointment());
		persistables.add(new Appointment());
		
		persistables.add(new Emergency());
		persistables.add(new MedicationEntry());
		persistables.add(new MedicationEntry());
		
		
		adapter.insertIntoDatabase(persistables);
		
		ArrayList<CalendarEntry> listFromDb = adapter.getSpecificCollection(CalendarEntry.class,true);
		Assert.assertEquals(5,listFromDb.size());
	}
	@Test
	public void testEntryAndCollectionUpdate()
	{
		MongoDbAdapter adapter = new MongoDbAdapter();
		adapter.erase();
		
		ArrayList<Persistable> persistables = new ArrayList<>();
		persistables.add(new Appointment());
		persistables.add(new Appointment());
		persistables.add(new Appointment());
		
		persistables.add(new Emergency());
		persistables.add(new MedicationEntry());
		persistables.add(new MedicationEntry());

		adapter.insertIntoDatabase(persistables);
		
		
		((Appointment)persistables.get(0)).setDescription("why cross the chicken the road?");
		adapter.updateCollection(persistables);
		
		Appointment updatedAppointment = (Appointment) adapter.getEntryFromDatabase(persistables.get(0));
		
		Assert.assertEquals(((Appointment)persistables.get(0)).getDescription(), updatedAppointment.getDescription());
		
	}
}
