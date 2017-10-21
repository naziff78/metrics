package org.demo.test;

import org.demo.bean.MetricsRegistry;

public class MetricsRegistryFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public MetricsRegistry newMetricsRegistry() {

		Integer id = mockValues.nextInteger();

		MetricsRegistry metricsRegistry = new MetricsRegistry();
		metricsRegistry.setId(id);
		return metricsRegistry;
	}
	
}
