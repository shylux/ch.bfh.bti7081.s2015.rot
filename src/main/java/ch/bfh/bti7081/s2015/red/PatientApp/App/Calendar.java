package ch.bfh.bti7081.s2015.red.PatientApp.App;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import ch.bfh.bti7081.s2015.red.PatientApp.Db.MongoDbAdapter;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.CalendarEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.GpsActivity;
import ch.bfh.bti7081.s2015.red.PatientApp.Utils.CalendarEntryComparator;
import ch.bfh.bti7081.s2015.red.PatientApp.Utils.DateUtils;

public class Calendar {
	final private  static int  NOTIFACATION_MINUTES_ACTIVITY = 60;
	final private static int NOTIFICATION_MINUTES_OTHER = 90;
	private ArrayList<CalendarEntry> entries = new ArrayList<CalendarEntry>();

    /**
     * <p>Checks if the date is after today ignoring time.</p>
     * @throws IllegalArgumentException if the date is <code>null</code>
     */
	
	public Calendar()
	{
		
		MongoDbAdapter mongoDb = new MongoDbAdapter();
		entries = mongoDb.getSpecificCollection(CalendarEntry.class,true);
	}
	
	
	/**
	 * Returns all CalendarEntries for today
	 * @return ArrayList
	 */
	public ArrayList<CalendarEntry> getTodayEntries()
	{
		return getEntriesForDay(java.util.Calendar.getInstance().getTime());
	}

	/**
	 * Returns all CalendarEntries for date
     * @param date, not altered, not null
	 * @return ArrayList
	 */
	public ArrayList<CalendarEntry> getEntriesForDay(Date date)
	{
		ArrayList<CalendarEntry> selectedEntries = new ArrayList<CalendarEntry>();

		for(int i = 0; i < entries.size(); i++) {
			//Entry is starting or ending on this day
			if(DateUtils.isSameDay(entries.get(i).getStartTime(), date) || DateUtils.isSameDay(entries.get(i).getEndTime(), date)) {
				selectedEntries.add(entries.get(i));
			}
			//Entry is starting before and ending after day
			else if(DateUtils.isBeforeDay(entries.get(i).getStartTime(), date) && DateUtils.isAfterDay(entries.get(i).getEndTime(), date)) {
				selectedEntries.add(entries.get(i));
			}
		}
		return selectedEntries;
	}

	/**
	 * Returns all entries starting today
	 * @return ArrayList
	 */
	public ArrayList<CalendarEntry> getEntriesStartingToday()
	{
		return getEntriesStartingOnDay(java.util.Calendar.getInstance().getTime());
	}

	/**
	 * Returns all entries starting on date
	 * @param date
	 * @return ArrayList
	 */
	public ArrayList<CalendarEntry> getEntriesStartingOnDay(Date date)
	{
		ArrayList<CalendarEntry> selectedEntries = new ArrayList<CalendarEntry>();

		for(int i = 0; i < entries.size(); i++) {
			//Entry is starting or ending on this day
			if(entries.get(i).getStartTime() !=null)
			{
				if(DateUtils.isSameDay(entries.get(i).getStartTime(), date)) {
					selectedEntries.add(entries.get(i));
				}
			}
		}
		return selectedEntries;
	}

	/**
	 * Returns all todays Activities without differentiate if they are finished
	 * @return ArrayList
	 */
	public ArrayList<Activity> getActivityStartingToday()
	{
		return getActivityStartingOnDay(java.util.Calendar.getInstance().getTime());
	}

	/**
	 * Returns all Activities of date without differentiate if they are finished
	 * @return ArrayList
	 */
	public ArrayList<Activity> getActivityStartingOnDay(Date date)
	{
		ArrayList<Activity> selectedActivities = new ArrayList<Activity>();

		for(int i = 0; i < entries.size(); i++) {
			//Activity is starting or ending on this day
			if(DateUtils.isSameDay(entries.get(i).getStartTime(), date)) {
				if(entries.get(i) instanceof Activity)
					selectedActivities.add((Activity)entries.get(i));
			}
		}
		return selectedActivities;
	}

	/**
	 * Returns todays next CalendarEntry starting in the future (entries in the past are bypassed)
	 * @return CalendarEntry
	 */
	public CalendarEntry getTodaysNextEntry()
	{
		ArrayList<CalendarEntry> selectedEntries = new ArrayList<CalendarEntry>();

		for(int i = 0; i < entries.size(); i++) {
			//Entry is starting or ending on this day
			if(DateUtils.isToday(entries.get(i).getStartTime()) && java.util.Calendar.getInstance().getTime().compareTo(entries.get(i).getStartTime()) > 0)  {
				selectedEntries.add(entries.get(i));
			}
		}

		Collections.sort(selectedEntries, new CalendarEntryComparator());

		return selectedEntries.get(0);
	}

	/**
	 * Returns todays next Activity (finished and past activities are bypassed)
	 * @return CalendarEntry
	 */
	public Activity getTodaysNextActivity()
	{
		//TODO: Check if activity isn't already finished
		//TODO: Possibility for optional activities?

		ArrayList<Activity> selectedActivities = new ArrayList<Activity>();

		for(int i = 0; i < entries.size(); i++) {
			if(DateUtils.isToday(entries.get(i).getStartTime()))  {
				if(entries.get(i) instanceof Activity){
					Activity a = (Activity)entries.get(i);
					if(!a.isDone()) {
						selectedActivities.add((Activity)entries.get(i));
					}
				}
			}
		}

		Collections.sort(selectedActivities, new CalendarEntryComparator());

		return selectedActivities.get(0);
	}

	/**
	 * Returns all unfinished Activities
	 * @return CalendarEntry
	 */
	public ArrayList<Activity> getUnfinishedActivity()
	{
		ArrayList<Activity> activities = new ArrayList<Activity>();

		for(int i = 0; i < entries.size(); i++) {
			if(entries.get(i) instanceof Activity){
				Activity a = (Activity)entries.get(i);
				if(a.getActivityState() == null||a.getActivityState().getStateShortName().equals("Started") ||
					a.getActivityState().getStateShortName().equals("Ready")||
					a.getActivityState().getStateShortName().equals("InProgress")) 
				{
					activities.add((Activity)entries.get(i));
				}
			}
		}

		Collections.sort(activities, new CalendarEntryComparator());

		return activities;
	}

	/**
	 * this method gets all relevant notifications from the database
	 * 
	 * @return
	 */
	public ArrayList<CalendarEntry>getNotifications()
	{
		
		/**
		 * TODO: Refactor with polymorphismn
		 */
		ArrayList<CalendarEntry> notifications = new ArrayList<>();
		MongoDbAdapter mongoDb = new MongoDbAdapter();
		entries =   mongoDb.getSpecificCollection(CalendarEntry.class,true);
		for(int i =0; i < entries.size();i++)
		{
			if(entries.get(i) instanceof Activity)
			{
				if(DateUtils.startsSoon(entries.get(i).getEndTime(), NOTIFACATION_MINUTES_ACTIVITY))
				{
					Activity currentActivity = (Activity) entries.get(i);
					if(currentActivity.getStateName().equals("InProgress"))
					{
						notifications.add(currentActivity);
					}
				}
			}
			else
			{
				if(DateUtils.startsSoon(entries.get(i).getStartTime(), NOTIFICATION_MINUTES_OTHER))
				{
					notifications.add(entries.get(i));
				}
			}
		}
		return notifications;
	}
	
	public ArrayList<Activity>getAllActivites() {  
		MongoDbAdapter mongoDb = new MongoDbAdapter();
		ArrayList<Activity> allActivities = mongoDb.getSpecificCollection(GpsActivity.class);
		return allActivities;
	}

	public void updateCalendarEntries()
	{
		//TODO: What's this function used for??
	}	
}