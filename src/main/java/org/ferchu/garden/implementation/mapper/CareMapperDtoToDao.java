package org.ferchu.garden.implementation.mapper;

import org.ferchu.garden.generated.model.Care;
import org.ferchu.garden.implementation.dao.CareDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.time.Duration;
import java.util.List;

@Mapper(imports = Duration.class)
public interface CareMapperDtoToDao {

    CareTypeMapperDtoToDao careTypeMapper = Mappers.getMapper(CareTypeMapperDtoToDao.class);

    @Mappings({
            @Mapping(expression = "java(Duration.ofSeconds(object.getApplicationDuration()))",
                    target = "applicationDurationRange"),
            @Mapping(expression = "java(careTypeMapper.transform(object.getCareType()))",
                    target = "careTypeDao")
    })

    CareDao transform(Care object);
    List<CareDao> map(List<Care> object);
}
