package org.ferchu.garden.implementation.mapper;

import org.ferchu.garden.generated.model.Plant;
import org.ferchu.garden.generated.model.PlantType;
import org.ferchu.garden.implementation.dao.PlantDao;
import org.ferchu.garden.implementation.dao.PlantTypeDao;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PlantTypesMapperDaoToDto {

    public List<PlantType> map(List<PlantTypeDao> plants);
    public PlantType convert(PlantTypeDao plant);
}
