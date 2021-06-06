/*
 * Created on Oct 18, 2011
 */
package com.mtripode.pettest1.abscomponent;

import java.util.Hashtable;

public interface Selection extends UIEditable, SupportsChangeListener {

    /**
     * @param values
     */
    public void setValues(Hashtable values);

    public String getValue();
}