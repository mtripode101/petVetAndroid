package com.mtripode.pettest1.abscomponent;

import java.util.Hashtable;

import com.mtripode.pettest1.entity.Entity;
import com.mtripode.pettest1.factory.Form;

import android.app.Activity;

/**
 * Interface used to define common behaviour for any Graphical Component that
 * can be used as a button. Bottons can be used to "send" forms in almost the
 * same way, an html form is submited.
 */
public interface UIButton {
    public CommandGUI getClickCommand();

    public void setClickCommand(CommandGUI command);
    
    void setActivity (Activity activity);
    
    void setEntity (Entity entity);
    
    Entity getEntity ();
    
    public void setParams (Hashtable params);
    
    public void submitForm(Form form);

    public Form getForm();

}
