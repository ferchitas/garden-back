package org.ferchu.garden.implementation.mapper;

import org.ferchu.garden.generated.model.Plant;
import org.ferchu.garden.generated.model.PlantType;
import org.ferchu.garden.implementation.dao.PlantDao;
import org.ferchu.garden.implementation.dao.PlantTypeDao;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PlantTypesMapperDtoToDao {

    public List<PlantTypeDao> map(List<PlantType> plants);
    public PlantTypeDao convert(PlantType plant);
}
