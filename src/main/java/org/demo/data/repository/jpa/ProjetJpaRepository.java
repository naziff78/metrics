package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.ProjetEntity;

/**
 * Repository : Projet.
 */
public interface ProjetJpaRepository extends PagingAndSortingRepository<ProjetEntity, Integer> {

}
