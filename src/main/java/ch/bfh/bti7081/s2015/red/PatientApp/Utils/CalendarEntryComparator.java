package ch.bfh.bti7081.s2015.red.PatientApp.Utils;

import java.util.Comparator;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.CalendarEntry;


public class CalendarEntryComparator implements Comparator<CalendarEntry> {
    @Override
    public int compare(CalendarEntry e1, CalendarEntry e2) {
        return e1.getStartTime().compareTo(e2.getStartTime());
    }
}
