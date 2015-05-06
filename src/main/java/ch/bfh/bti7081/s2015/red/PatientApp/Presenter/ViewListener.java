package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;

public interface ViewListener {
	
	/**
	 * notify a button click to the presenter
	 * @param property name of the button
	 * @param data data e.g. specific model
	 */
	public void buttonClick(String property,Object data);
	
	/**
	 * notify other events to the presenter (e.g. Time is up)
	 * @param event event name
	 * @param data data e.g. specific model
	 */
	public void triggerEvent(String event,Object data);
	
	/**
	 * for displaying the specific view
	 */
	public void displayView();
	
	
	
	
}
