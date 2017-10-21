package org.demo.test;

import org.demo.bean.Timers;

public class TimersFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Timers newTimers() {

		Integer id = mockValues.nextInteger();

		Timers timers = new Timers();
		timers.setId(id);
		return timers;
	}
	
}
