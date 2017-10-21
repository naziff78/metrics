package org.demo.test;

import org.demo.bean.Projet;

public class ProjetFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Projet newProjet() {

		Integer id = mockValues.nextInteger();

		Projet projet = new Projet();
		projet.setId(id);
		return projet;
	}
	
}
