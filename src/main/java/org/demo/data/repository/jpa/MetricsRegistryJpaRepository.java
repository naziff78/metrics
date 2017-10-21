package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.MetricsRegistryEntity;

/**
 * Repository : MetricsRegistry.
 */
public interface MetricsRegistryJpaRepository extends PagingAndSortingRepository<MetricsRegistryEntity, Integer> {

}
