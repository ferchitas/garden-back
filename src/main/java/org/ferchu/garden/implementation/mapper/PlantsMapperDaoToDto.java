package org.ferchu.garden.implementation.mapper;

import org.ferchu.garden.generated.model.Plant;
import org.ferchu.garden.implementation.dao.PlantDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface PlantsMapperDaoToDto {

    public List<Plant> map(List<PlantDao> plants);

    @Mappings(@Mapping(source = "plantTypeDao", target = "plantType"))
    public Plant convert(PlantDao plant);
}
