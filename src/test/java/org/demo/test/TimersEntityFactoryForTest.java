package org.demo.test;

import org.demo.bean.jpa.TimersEntity;

public class TimersEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public TimersEntity newTimersEntity() {

		Integer id = mockValues.nextInteger();

		TimersEntity timersEntity = new TimersEntity();
		timersEntity.setId(id);
		return timersEntity;
	}
	
}
