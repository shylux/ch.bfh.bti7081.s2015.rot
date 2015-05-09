package ch.bfh.bti7081.s2015.red.PatientApp;

import javax.servlet.annotation.WebServlet;

import ch.bfh.bti7081.s2015.red.PatientApp.View.NavigatorUI;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

public class PatientAppStarter {
	
	
	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(widgetset="ch.bfh.bti7081.s2015.red.PatientApp.MyAppWidgetset",ui = NavigatorUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet 
    {
		
    }
	
}
