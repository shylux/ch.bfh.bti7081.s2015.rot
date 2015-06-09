package ch.bfh.bti7081.s2015.red.PatientApp.Test;

import java.util.ArrayList;
<<<<<<< HEAD

import org.junit.Assert;
import org.junit.Before;
=======
import org.junit.Assert;
>>>>>>> 049c9aacdb695faa33d6a9a1748f72fd436a9c38
import org.junit.Test;
import org.junit.Assert;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.MedicationEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.View.MedicationView;
<<<<<<< HEAD
import com.vaadin.testbench.ScreenshotOnFailureRule;
import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.LabelElement;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestMedicationEntry extends TestBenchTestCase{
	
	@Before
	public void setUp() throws Exception {
	    //setDriver(new FirefoxDriver());
	}
	
	/**
     * Opens the URL where the application is deployed.
     */
    private void openTestUrl() {
        getDriver().get("http://localhost:8080/");
    }
	
=======

public class TestMedicationEntry{
>>>>>>> 049c9aacdb695faa33d6a9a1748f72fd436a9c38
	@Test
	public void TestMedicationEntry()
	{
		String name = "Sanalepsi N";
		String description = "Zur Beruhigung und als Schlafhilfe";
<<<<<<< HEAD
		String howMuchADay = "Pro Dosis 50 Tropfen";
=======
		String howMuchADay = "";
>>>>>>> 049c9aacdb695faa33d6a9a1748f72fd436a9c38
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
