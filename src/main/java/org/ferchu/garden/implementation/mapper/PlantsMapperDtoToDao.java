package org.ferchu.garden.implementation.mapper;

import org.ferchu.garden.generated.model.Plant;
import org.ferchu.garden.implementation.dao.PlantDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface PlantsMapperDtoToDao {

    public List<PlantDao> map(List<Plant> plants);

    @Mappings(@Mapping(source = "plantType", target = "plantTypeDao"))
    public PlantDao convert(Plant plant);
}
