/*
 * Created on 29 avr. 2016 ( Time 14:11:56 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.web.listitem;

import org.demo.bean.Projet;
import org.demo.web.common.ListItem;

public class ProjetListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public ProjetListItem(Projet projet) {
		super();

		this.value = ""
			 + projet.getId()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = projet.toString();
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getLabel() {
		return label;
	}

}
