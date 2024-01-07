package org.ferchu.garden.implementation.mapper;

import org.ferchu.garden.generated.model.Care;
import org.ferchu.garden.implementation.dao.CareDao;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CareMapperDtoToDao {

    List<CareDao> map(List<Care> object);
}
