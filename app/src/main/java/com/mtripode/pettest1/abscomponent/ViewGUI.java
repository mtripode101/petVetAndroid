package com.mtripode.pettest1.abscomponent;

import android.app.Activity;

public interface ViewGUI {
	 public CommandGUI getClickCommand();

	 public void setClickCommand(CommandGUI command); 
	 
	 void setActivity (Activity activity);
}
