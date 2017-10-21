package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.TimersEntity;

/**
 * Repository : Timers.
 */
public interface TimersJpaRepository extends PagingAndSortingRepository<TimersEntity, Integer> {

}
