package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;

import ch.bfh.bti7081.s2015.red.PatientApp.View.View;

/**
 * Base class of all presenters.
 * The presenter is the glue between view and model. Consult the vaadin doc for further explanation.
 * @param <T> the model class
 * @author James Mayr
 */
public abstract class BasePresenter<T> implements ViewListener<T>{

	// The view to render the model
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
