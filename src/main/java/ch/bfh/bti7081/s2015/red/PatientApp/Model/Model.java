package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import java.util.ArrayList;

public interface Model <T> {
	
	
	/**
	 * update model data
	 * @param data
	 */
	public void update(T data);
	
	/**
	 * update model data
	 * @param data
	 */
	public void update();
	
	
	/**
	 * get model data
	 * @return
	 */
	public T getData();
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<T> getCollection();
	
	/**
	 * 
	 * @param o
	 */
	public void add(T o);
}
