package ch.bfh.bti7081.s2015.red.PatientApp.Test;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.MedicationEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.View.MedicationView;

public class TestMedicationEntry{
	@Test
	public void TestMedicationEntry()
	{
		String name = "Sanalepsi N";
		String description = "Zur Beruhigung und als Schlafhilfe";
		String howMuchADay = "";
		String howToTake = "Tropfen direkt in den Mund tröpfeln";
		ArrayList<String> times = new ArrayList<String>(); 
		
		times.add("21:00 Uhr");
		times.add("20:00 Uhr");
		
		MedicationEntry medication = new MedicationEntry(
										name, 
										description, 
										howMuchADay, 
										howToTake, 
										times
									);

		MedicationView view = new MedicationView();
		view.update(medication);
	}
	
}
