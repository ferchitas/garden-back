package org.ferchu.garden.test.implementation.services;

import org.ferchu.garden.generated.model.Plant;
import org.ferchu.garden.generated.model.PlantType;
import org.ferchu.garden.implementation.dao.PlantDao;
import org.ferchu.garden.implementation.dao.PlantTypeDao;
import org.ferchu.garden.implementation.exceptions.MissingPlantTypeException;
import org.ferchu.garden.implementation.exceptions.UnexistingObjectException;
import org.ferchu.garden.implementation.repository.PlantTypesRepository;
import org.ferchu.garden.implementation.repository.PlantsRepository;
import org.ferchu.garden.implementation.services.PlantsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PlantServicesTest {

    @InjectMocks
    PlantsService plantsService;

    @Mock
    PlantsRepository plantsRepository;

    @Mock
    PlantTypesRepository plantTypesRepository;

    Plant plant;

    PlantType plantType;

    PlantDao plantDao;

    PlantTypeDao plantTypeDao;

    @BeforeEach
    public void setUp() {

        plantDao = new PlantDao();
        plantTypeDao = new PlantTypeDao();
        plantTypeDao.setId(BigDecimal.ONE.longValue());
        plantDao.setId(BigDecimal.ONE.longValue());
        plantDao.setPlantTypeDao(plantTypeDao);
        plantType = new PlantType();
        plantType.setId(BigDecimal.ONE);
        plant = new Plant();
        plant.setPlantType(plantType);
        plant.setId(BigDecimal.ONE);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllPlantsTest() {

        Mockito.when(plantsRepository.findAll()).thenReturn(new ArrayList<>());
        Assertions.assertNotNull(plantsService.getAllPlants());

    }

    @Test
    public void createPlantTest() {

        Mockito.when(plantTypesRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new PlantTypeDao()));
        Mockito.when(plantsRepository.save(Mockito.any())).thenReturn(new PlantDao());
        Assertions.assertNotNull(plantsService.createPlant(plant));
    }

    @Test
    public void createPlantNullErrorTest() {

        Assertions.assertThrows(MissingPlantTypeException.class, () -> plantsService.createPlant(new Plant()));
    }

    @Test
    public void createPlantNoPlantTypeErrorTest() {

        Mockito.when(plantTypesRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        Assertions.assertThrows(UnexistingObjectException.class, () -> plantsService.createPlant(plant));

    }

    @Test
    public void updatePlantTest() {

        Mockito.doReturn(Optional.of(plantDao)).when(plantsRepository).findById(Mockito.anyLong());
        Mockito.doReturn(Optional.of(plantTypeDao)).when(plantTypesRepository).findById(Mockito.anyLong());
        Mockito.when(plantsRepository.save(Mockito.any())).thenReturn(new PlantDao());
        Assertions.assertNotNull(plantsService.updatePlant(plant));
    }

    @Test
    public void updatePlantNullErrorTest() {

        Assertions.assertThrows(UnexistingObjectException.class, () -> plantsService.updatePlant(new Plant()));
    }
}
