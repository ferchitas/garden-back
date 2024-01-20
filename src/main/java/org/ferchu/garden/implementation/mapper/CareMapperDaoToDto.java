package org.ferchu.garden.implementation.mapper;

import org.ferchu.garden.generated.model.Care;
import org.ferchu.garden.implementation.dao.CareDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CareMapperDaoToDto {

    CareTypeMapperDaoToDto careTypeMapper = Mappers.getMapper(CareTypeMapperDaoToDto.class);

    @Mappings({
            @Mapping(expression = "java(object.getApplicationDurationRange().getSeconds())",
                    target = "applicationDuration"),
            @Mapping(expression = "java(careTypeMapper.transform(object.getCareTypeDao()))",
                    target = "careType")
    })
    Care transform(CareDao object);

    List<Care> map(List<CareDao> object);
}
