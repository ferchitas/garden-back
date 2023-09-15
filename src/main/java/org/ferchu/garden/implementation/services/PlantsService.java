package org.ferchu.garden.implementation.services;

import org.ferchu.garden.generated.model.ErrorType;
import org.ferchu.garden.generated.model.Plant;
import org.ferchu.garden.implementation.dao.PlantDao;
import org.ferchu.garden.implementation.exceptions.MissingPlantTypeException;
import org.ferchu.garden.implementation.exceptions.NotCreatedPlantTypeException;
import org.ferchu.garden.implementation.exceptions.UnexistingObjectException;
import org.ferchu.garden.implementation.exceptions.builder.ErrorAppBuilder;
import org.ferchu.garden.implementation.mapper.PlantTypesMapperDtoToDao;
import org.ferchu.garden.implementation.mapper.PlantsMapperDaoToDto;
import org.ferchu.garden.implementation.mapper.PlantsMapperDtoToDao;
import org.ferchu.garden.implementation.repository.PlantTypesRepository;
import org.ferchu.garden.implementation.repository.PlantsRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
public class PlantsService implements PlantsServiceI {

    @Autowired
    PlantsRepository plantsRepository;

    @Autowired
    PlantTypesRepository plantTypesRepository;

    @Override
    public List<Plant> getAllPlants() {

        PlantsMapperDaoToDto plantsMapperDaoToDto = Mappers.getMapper(PlantsMapperDaoToDto.class);

        List<PlantDao> plantsDao = (List<PlantDao>) plantsRepository.findAll();
        List<Plant> plants = plantsMapperDaoToDto.map(plantsDao);
        return plants;
    }

    @Override
    public Plant createPlant(Plant plant) {

        PlantsMapperDtoToDao plantsMapperDtoToDao = Mappers.getMapper(PlantsMapperDtoToDao.class);
        PlantTypesMapperDtoToDao plantTypesMapperDtoToDao = Mappers.getMapper(PlantTypesMapperDtoToDao.class);
        PlantsMapperDaoToDto plantsMapperDaoToDto = Mappers.getMapper(PlantsMapperDaoToDto.class);
        ErrorAppBuilder errorAppBuilder = new ErrorAppBuilder();
        Plant plantSaved = null;
        if(Objects.nonNull(plant.getPlantType()) && Objects.nonNull(plant.getPlantType().getId())) {
            if(plantTypesRepository.findById(plantTypesMapperDtoToDao.convert(plant.getPlantType()).getId()).isPresent()) {

                PlantDao plantDao = (PlantDao) plantsRepository.save(plantsMapperDtoToDao.convert(plant));
                plantSaved = plantsMapperDaoToDto.convert(plantDao);
            }
            else {
                errorAppBuilder.name("")
                        .description("")
                        .errorCode(BigDecimal.valueOf(1))
                        .httpCode(BigDecimal.valueOf(404))
                        .errorType(ErrorType.OBJECT_NOT_EXISTING);
                throw new NotCreatedPlantTypeException(errorAppBuilder.build());
            }
        }
        else {
            errorAppBuilder.name("")
                    .description("")
                    .errorCode(BigDecimal.valueOf(1))
                    .httpCode(BigDecimal.valueOf(404))
                    .errorType(ErrorType.OBJECT_NOT_EXISTING);
            throw new MissingPlantTypeException(errorAppBuilder.build());
        }
        return plantSaved;
    }

    @Override
    public Plant updatePlant(Plant plant) {

        PlantsMapperDtoToDao plantsMapperDtoToDao = Mappers.getMapper(PlantsMapperDtoToDao.class);
        PlantsMapperDaoToDto plantsMapperDaoToDto = Mappers.getMapper(PlantsMapperDaoToDto.class);
        ErrorAppBuilder errorAppBuilder = new ErrorAppBuilder();
        Plant plantResult;

        PlantDao plantDao = plantsMapperDtoToDao.convert(plant);
        if(plantsRepository.findById(plantDao.getId()).isPresent()) {

            PlantDao plantSavedDao = (PlantDao) plantsRepository.save(plantsMapperDtoToDao.convert(plant));
            plantResult = plantsMapperDaoToDto.convert(plantSavedDao);
        }
        else {
            errorAppBuilder.name("")
                    .description("")
                    .errorCode(BigDecimal.valueOf(1))
                    .httpCode(BigDecimal.valueOf(404))
                     .errorType(ErrorType.OBJECT_NOT_EXISTING);
            throw new UnexistingObjectException(errorAppBuilder.build());
        }
        return plantResult;
    }

    @Override
    public Void removePlant(Plant plant) {

        PlantsMapperDtoToDao plantsMapperDtoToDao = Mappers.getMapper(PlantsMapperDtoToDao.class);
        plantsRepository.delete(plantsMapperDtoToDao.convert(plant));
        return null;
    }
}
