package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.CalendarEntry;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.components.calendar.CalendarComponentEvents.EventClick;
import com.vaadin.ui.components.calendar.event.BasicEvent;
import com.vaadin.ui.components.calendar.event.BasicEventProvider;



@Theme("mytheme")
@Widgetset("ch.bfh.bti7081.s2015.red.PatientApp.MyAppWidgetset")
public class CalendarView extends BaseView<CalendarEntry>
{
	private BasicEventProvider m_provider =  new BasicEventProvider();

	private Navigator m_navigator;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3046022586670092652L;

	public CalendarView(Navigator nav) {
		m_navigator = nav;
	}


	@Override
	public void enter(ViewChangeEvent event) {

		this.removeAllComponents();
		//setContent(layout);

		com.vaadin.ui.Calendar cal = new com.vaadin.ui.Calendar(m_provider);
		cal.setReadOnly(true);
		cal.setWidth("100%");
		//cal.setHeight("300px");
		cal.setHandler(new com.vaadin.ui.components.calendar.CalendarComponentEvents.EventClickHandler() {
			public void eventClick(EventClick event) {
				BasicEvent e = (BasicEvent) event.getCalendarEvent();

				m_navigator.navigateTo(NavigatorUI.LIFEUPINDEX);
				// Do something with it
				new Notification("Event clicked: " + e.getCaption(),
						e.getDescription()).show(Page.getCurrent());
			}
		});
		

		// add the default homescreen button
		this.addComponent(addStartPageNavigation());
		buttonStartPage.addClickListener(this);
		// end of adding default navigation		
		
		addComponent(cal);
		
		
	}



	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		
		// Navigate to startscreen
		if (event.getButton().getCaption().equals(stringStartPage)) { 
			getUI().getNavigator().navigateTo(NavigatorUI.STARTSCREEN);		
		}
	}



	@Override
	public void update(CalendarEntry model) {
		// TODO Auto-generated method stub

	}



	@Override
	public void update(ArrayList<CalendarEntry> data) {
		// TODO Auto-generated method stub

		System.out.println(data.size()+" Elemente im Kalender");
		for(int i = 0; i < data.size(); i++) {
			CalendarEntry entry = data.get(i);

			BasicEvent be = new BasicEvent();
			be.setCaption(entry.getShortName());
			be.setDescription(entry.getDescription());
			be.setStart(entry.getStartTime());
			be.setEnd(entry.getEndTime());
			m_provider.addEvent(be);
		}

	}
}
