package com.mtripode.pettest1.factory;

import java.util.Hashtable;

/**
 * Fields clases implementing this interface can override the default behavior
 * used to retrieve the info that�s going to be submitted.
 */
public interface UICallAdaptorField {
	public Hashtable prepareCall(Hashtable callParam);
}
