package com.mtripode.pettest1.abscomponent;

import java.util.Hashtable;

import com.mtripode.pettest1.factory.Form;

public abstract class CommandGUI {

	private int icon = UIConstants.ICON_NO_ICON;

	public abstract void execute(Hashtable params);

	public abstract String getName();

	public abstract CommandGUI setName(String name);

	public abstract boolean success();

	public int getIcon() {
		return this.icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}
	
	public abstract Hashtable getParams ();
	
    public abstract Form getForm();
    
    public abstract void setForm(Form form);

}
