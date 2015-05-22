package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;
import java.util.Date;

import ch.bfh.bti7081.s2015.red.PatientApp.App.Calendar;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.components.calendar.event.BasicEvent;
import com.vaadin.ui.components.calendar.event.CalendarEvent;



@Theme("mytheme")
@Widgetset("ch.bfh.bti7081.s2015.red.PatientApp.MyAppWidgetset")
public class CalendarView extends BaseView<Calendar>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3046022586670092652L;
	
	
	
	@Override
	public void enter(ViewChangeEvent event) {

		this.removeAllComponents();
        //setContent(layout);
		
        com.vaadin.ui.Calendar cal = new com.vaadin.ui.Calendar("Kalender");
        cal.setReadOnly(true);

        BasicEvent cevent = new BasicEvent();
        cevent.setCaption("My Event");
        cevent.setDescription("My Event Description");
        cevent.setStart(new Date());
        
        java.util.Calendar cal2 = java.util.Calendar.getInstance(); // creates calendar
        cal2.setTime(new Date()); // sets calendar time/date
        cal2.add(java.util.Calendar.HOUR_OF_DAY, 1); // adds one hour
        
        
        cevent.setEnd(cal2.getTime());
        cal.addEvent(cevent);
        cal.setWidth("100%");
        //cal.setHeight("300px");
        addComponent(cal);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Calendar model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ArrayList<Calendar> data) {
		// TODO Auto-generated method stub
		
	}
}
