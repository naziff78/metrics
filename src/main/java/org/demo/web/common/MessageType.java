/*
 * Created on 29 avr. 2016 ( Time 14:11:56 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.web.common;

public enum MessageType {
	
	SUCCESS,
	INFO,
	WARNING,
	DANGER;
	
	public String getCss() {
		return name().toLowerCase();
	}
	
}
