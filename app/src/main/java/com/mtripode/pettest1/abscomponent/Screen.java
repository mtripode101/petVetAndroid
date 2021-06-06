package com.mtripode.pettest1.abscomponent;

import java.util.Hashtable;
import java.util.Vector;

import android.app.Activity;

public interface Screen {

	public void addCommand(CommandGUI command);

	public boolean canClose();

	public void close();

	public Vector getCommands();

	/**
	 * @return Returns the name.
	 */
	public String getName();

	public String getTitle();

	public void setCanClose(boolean canClose);

	public void setCommands(Vector commands);
	
	public void setActivity (Activity activity);

	/**
	 * @param name
	 *            The name to set.
	 */
	public Screen setName(String name);

	/**
	 * @param saveCommand
	 *            the saveCommand to set
	 */
	// public void setSaveCommand(UICommand saveCommand);

	/**
	 * @param saveform
	 *            the saveform to set
	 */
	// public void setSaveform(Form saveform);

	public void setParams(Hashtable params);

	public Hashtable getParams();
	
    public void addSearchField(UIEditable field);
    
    public void setSearchCommand(CommandGUI command);
    
    public void showSearchPanel();
    
    public boolean hasSearchFields();

}
