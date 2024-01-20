package org.ferchu.garden.implementation.mapper;

import org.ferchu.garden.generated.model.CareType;
import org.ferchu.garden.implementation.dao.CareTypeDao;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CareTypeMapperDtoToDao {

    CareTypeDao transform(CareType object);

    List<CareTypeDao> map(List<CareType> object);
}
