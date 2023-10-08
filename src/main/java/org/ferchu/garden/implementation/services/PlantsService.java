package org.ferchu.garden.implementation.services;

import org.ferchu.garden.generated.model.ErrorType;
import org.ferchu.garden.generated.model.Plant;
import org.ferchu.garden.implementation.dao.PlantDao;
import org.ferchu.garden.implementation.dao.PlantTypeDao;
import org.ferchu.garden.implementation.exceptions.MissingPlantTypeException;
import org.ferchu.garden.implementation.exceptions.NotCreatedPlantTypeException;
import org.ferchu.garden.implementation.exceptions.UnexistingObjectException;
import org.ferchu.garden.implementation.exceptions.builder.ErrorAppBuilder;
import org.ferchu.garden.implementation.mapper.PlantTypesMapperDtoToDao;
import org.ferchu.garden.implementation.mapper.PlantsMapperDaoToDto;
import org.ferchu.garden.implementation.mapper.PlantsMapperDtoToDao;
import org.ferchu.garden.implementation.repository.PlantTypesRepository;
import org.ferchu.garden.implementation.repository.PlantsRepository;
import org.ferchu.garden.implementation.utils.Constants;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
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
        return plantsMapperDaoToDto.map(plantsDao);
    }

    @Override
    public Plant createPlant(Plant plant) {

        PlantsMapperDtoToDao plantsMapperDtoToDao = Mappers.getMapper(PlantsMapperDtoToDao.class);
        PlantTypesMapperDtoToDao plantTypesMapperDtoToDao = Mappers.getMapper(PlantTypesMapperDtoToDao.class);
        PlantsMapperDaoToDto plantsMapperDaoToDto = Mappers.getMapper(PlantsMapperDaoToDto.class);
        ErrorAppBuilder errorAppBuilder = new ErrorAppBuilder();
        Plant plantSaved = null;
        if(Objects.nonNull(plant.getPlantType()) && Objects.nonNull(plant.getPlantType().getId())) {
            if(plantTypesRepository.findById(plant.getPlantType().getId().longValue()).isPresent()) {

                PlantDao plantDao = (PlantDao) plantsRepository.save(plantsMapperDtoToDao.convert(plant));
                plantSaved = plantsMapperDaoToDto.convert(plantDao);
            }
            else {
                errorAppBuilder
                        .errorCode(BigDecimal.valueOf(10001))
                        .httpCode(BigDecimal.valueOf(404))
                        .errorType(ErrorType.OBJECT_NOT_EXISTING)
                        .name(Constants.UNEXISTING_OBJECT_IN_DB_NAME_STR)
                        .description(String.format(Constants.UNEXISTING_OBJECT_IN_DB_DESCRIPTION_STR, PlantDao.class.getCanonicalName()));
                throw new UnexistingObjectException(errorAppBuilder.build());
            }
        }
        else {
            errorAppBuilder
                    .errorCode(BigDecimal.valueOf(10002))
                    .httpCode(BigDecimal.valueOf(400))
                    .errorType(ErrorType.MISSING_FIELD)
                    .name(Constants.MISSING_ELEMENT_IN_REQUEST_NAME_STR)
                    .description(String.format(Constants.MISSING_ELEMENT_IN_REQUEST_NAME_STR,
                            PlantTypeDao.class.getCanonicalName()));
            throw new MissingPlantTypeException(errorAppBuilder.build());
        }
        return plantSaved;
    }

    @Override
    public Plant updatePlant(Plant plant) throws UnexistingObjectException {

        PlantsMapperDtoToDao plantsMapperDtoToDao = Mappers.getMapper(PlantsMapperDtoToDao.class);
        PlantsMapperDaoToDto plantsMapperDaoToDto = Mappers.getMapper(PlantsMapperDaoToDto.class);
        ErrorAppBuilder errorAppBuilder = new ErrorAppBuilder();
        errorAppBuilder.errorCode(BigDecimal.valueOf(Constants.UNEXISTING_OBJECT_IN_DB_CODE))
                .httpCode(BigDecimal.valueOf(HttpStatus.NOT_FOUND.value()))
                .errorType(ErrorType.OBJECT_NOT_EXISTING);

        PlantDao plantDao = plantsMapperDtoToDao.convert(plant);
        if(plantsRepository.findById(plantDao.getId()).isEmpty()) {
            errorAppBuilder
                    .name(Constants.UNEXISTING_OBJECT_IN_DB_NAME_STR)
                    .description(String.format(Constants.UNEXISTING_OBJECT_IN_DB_DESCRIPTION_STR, PlantDao.class.getCanonicalName()));

            throw new UnexistingObjectException(errorAppBuilder.build());
        }
        if(Objects.isNull(plantDao.getPlantTypeDao()) ||
                plantTypesRepository.findById(plantDao.getPlantTypeDao().getId()).isEmpty()) {

            errorAppBuilder
                    .name(Constants.UNEXISTING_OBJECT_IN_DB_NAME_STR)
                    .description(String.format(Constants.UNEXISTING_OBJECT_IN_DB_DESCRIPTION_STR, PlantTypeDao.class.getCanonicalName()));
            throw new UnexistingObjectException(errorAppBuilder.build());

        }
        PlantDao plantSavedDao = (PlantDao) plantsRepository.save(plantsMapperDtoToDao.convert(plant));
        return plantsMapperDaoToDto.convert(plantSavedDao);
    }

    @Override
    public Void removePlant(Plant plant) {

        PlantsMapperDtoToDao plantsMapperDtoToDao = Mappers.getMapper(PlantsMapperDtoToDao.class);
        plantsRepository.delete(plantsMapperDtoToDao.convert(plant));
        return null;
    }
}
