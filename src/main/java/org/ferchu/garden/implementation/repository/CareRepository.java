package org.ferchu.garden.implementation.repository;

import org.ferchu.garden.implementation.dao.CareDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareRepository extends CrudRepository<CareDao, Long> {
}
