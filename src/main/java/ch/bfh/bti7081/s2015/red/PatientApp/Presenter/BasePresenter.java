package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;

import ch.bfh.bti7081.s2015.red.PatientApp.View.View;

/**
 * Base class of all presenters
 * @author James Mayr
 *
 * @param <T>
 */
public abstract class BasePresenter<T> implements ViewListener<T>{

	/**
	 * presenter's view
	 */
	protected View view;
	
	/**
	 * setup presenter view it's own view
	 * @param view
	 */
	public BasePresenter(View view)
	{
		this.view = view;
	}
	
	

}
