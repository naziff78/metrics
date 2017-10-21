package org.demo.test;

import org.demo.bean.jpa.MetricsRegistryEntity;

public class MetricsRegistryEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public MetricsRegistryEntity newMetricsRegistryEntity() {

		Integer id = mockValues.nextInteger();

		MetricsRegistryEntity metricsRegistryEntity = new MetricsRegistryEntity();
		metricsRegistryEntity.setId(id);
		return metricsRegistryEntity;
	}
	
}
