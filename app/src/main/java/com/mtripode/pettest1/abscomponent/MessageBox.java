/**
 * 
 */
package com.mtripode.pettest1.abscomponent;

/**
 * @author pmodic
 *
 */
public interface MessageBox {
	
	public static final String TYPE_ERROR = "ERROR";
	public static final String TYPE_MESSAGE = "MESSAGE";
	
	public void addMessage(String message);
	
}
