package org.ferchu.garden.implementation.repository;

import org.ferchu.garden.implementation.dao.PlantDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantsRepository extends CrudRepository<PlantDao, Long> {
}
