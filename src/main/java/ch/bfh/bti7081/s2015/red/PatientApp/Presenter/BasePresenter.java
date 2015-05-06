package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;

import ch.bfh.bti7081.s2015.red.PatientApp.View.View;

public abstract class BasePresenter implements ViewListener{

	protected View view;
	public BasePresenter(View view)
	{
		this.view = view;
	}

}
