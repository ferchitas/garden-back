package org.ferchu.garden.implementation.services;

import org.ferchu.garden.generated.model.Plant;
import org.ferchu.garden.generated.model.PlantType;
import org.ferchu.garden.implementation.dao.PlantDao;
import org.ferchu.garden.implementation.dao.PlantTypeDao;
import org.ferchu.garden.implementation.mapper.PlantTypesMapperDaoToDto;
import org.ferchu.garden.implementation.mapper.PlantTypesMapperDtoToDao;
import org.ferchu.garden.implementation.mapper.PlantsMapperDaoToDto;
import org.ferchu.garden.implementation.mapper.PlantsMapperDtoToDao;
import org.ferchu.garden.implementation.repository.PlantTypesRepository;
import org.ferchu.garden.implementation.repository.PlantsRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantTypesService implements PlantTypeServiceI {

    @Autowired
    PlantTypesRepository plantsTypesRepository;

//    @Override
//    public List<Plant> getAllPlants() {
//
//        PlantsMapperDaoToDto plantsMapperDaoToDto = Mappers.getMapper(PlantsMapperDaoToDto.class);
//
//        List<PlantDao> plantsDao = (List<PlantDao>) plantsRepository.findAll();
//        List<Plant> plants = plantsMapperDaoToDto.map(plantsDao);
//        return plants;
//    }
//
//    @Override
//    public Plant createPlant(Plant plant) {
//
//        PlantsMapperDtoToDao plantsMapperDtoToDao = Mappers.getMapper(PlantsMapperDtoToDao.class);
//        PlantsMapperDaoToDto plantsMapperDaoToDto = Mappers.getMapper(PlantsMapperDaoToDto.class);
//
//        PlantDao plantDao = (PlantDao) plantsRepository.save(plantsMapperDtoToDao.convert(plant));
//        Plant plantSaved = plantsMapperDaoToDto.convert(plantDao);
//        return plantSaved;
//    }
//
//    @Override
//    public Plant updatePlant(Plant plant) {
//
//        PlantsMapperDtoToDao plantsMapperDtoToDao = Mappers.getMapper(PlantsMapperDtoToDao.class);
//        PlantsMapperDaoToDto plantsMapperDaoToDto = Mappers.getMapper(PlantsMapperDaoToDto.class);
//
//        PlantDao plantDao = (PlantDao) plantsRepository.save(plantsMapperDtoToDao.convert(plant));
//        Plant plantSaved = plantsMapperDaoToDto.convert(plantDao);
//        return plantSaved;
//    }
//
//    @Override
//    public Void removePlant(Plant plant) {
//
//        PlantsMapperDtoToDao plantsMapperDtoToDao = Mappers.getMapper(PlantsMapperDtoToDao.class);
//        plantsRepository.delete(plantsMapperDtoToDao.convert(plant));
//        return null;
//    }

    @Override
    public List<PlantType> getAllPlantTypes() {

        PlantTypesMapperDaoToDto plantTypesMapperDaoToDto = Mappers.getMapper(PlantTypesMapperDaoToDto.class);

        List<PlantTypeDao> plantsTypesDao = (List<PlantTypeDao>) plantsTypesRepository.findAll();
        List<PlantType> plants = plantTypesMapperDaoToDto.map(plantsTypesDao);
        return plants;
    }

    @Override
    public PlantType createPlantType(PlantType plantType) {

        PlantTypesMapperDtoToDao plantTypesMapperDtoToDao = Mappers.getMapper(PlantTypesMapperDtoToDao.class);
        PlantTypesMapperDaoToDto plantTypesMapperDaoToDto = Mappers.getMapper(PlantTypesMapperDaoToDto.class);

        PlantTypeDao plantTypeDao =
                (PlantTypeDao) plantsTypesRepository.save(plantTypesMapperDtoToDao.convert(plantType));
        PlantType plantTypeSaved = plantTypesMapperDaoToDto.convert(plantTypeDao);
        return plantTypeSaved;
    }

    @Override
    public Void removePlantType(PlantType plantType) {

        PlantTypesMapperDtoToDao plantTypesMapperDtoToDao = Mappers.getMapper(PlantTypesMapperDtoToDao.class);
        plantsTypesRepository.delete(plantTypesMapperDtoToDao.convert(plantType));
        return null;
    }

    @Override
    public PlantType updatePlantType(PlantType plantType) {

        PlantTypesMapperDtoToDao plantTypesMapperDtoToDao = Mappers.getMapper(PlantTypesMapperDtoToDao.class);
        PlantTypesMapperDaoToDto plantTypesMapperDaoToDto = Mappers.getMapper(PlantTypesMapperDaoToDto.class);

        PlantTypeDao plantTypeDao =
                (PlantTypeDao) plantsTypesRepository.save(plantTypesMapperDtoToDao.convert(plantType));
        PlantType plantTypeSaved = plantTypesMapperDaoToDto.convert(plantTypeDao);
        return plantTypeSaved;
    }
}
