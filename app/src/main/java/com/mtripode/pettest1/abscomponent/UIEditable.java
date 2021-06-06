package com.mtripode.pettest1.abscomponent;

import com.mtripode.pettest1.factory.Form;

/**
 * This interface must be implemented by any Graphic Component that is going to
 * be used into forms, and whose value must be recovered.
 */
public interface UIEditable extends ViewGUI {
    public String getEditableId();

    public String getValue();

    public boolean hasChanged();

    public void setEditable(boolean editable);

    void setTextValue(String value);
    
    public void addToForm(Form form);
}
