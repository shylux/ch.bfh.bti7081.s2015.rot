package ch.bfh.bti7081.s2015.red.PatientApp.Test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.MedicationEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.View.MedicationView;
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
	
	@Test
	public void TestMedicationEntry()
	{
		String name = "Sanalepsi N";
		String description = "Zur Beruhigung und als Schlafhilfe";
		String howMuchADay = "Pro Dosis 50 Tropfen";
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
