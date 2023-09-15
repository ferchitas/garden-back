package org.ferchu.garden.implementation.api;

import org.ferchu.garden.generated.api.PlantTypeApiDelegate;
import org.ferchu.garden.generated.api.PlantsApiDelegate;
import org.ferchu.garden.generated.model.Plant;
import org.ferchu.garden.generated.model.PlantType;
import org.ferchu.garden.implementation.services.PlantTypeServiceI;
import org.ferchu.garden.implementation.services.PlantsServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantTypesApiImpl implements PlantTypeApiDelegate {

    @Autowired
    PlantTypeServiceI plantTypesService;

    @Override
    public ResponseEntity<List<PlantType>> getAllPlantTypes() {

        return ResponseEntity.ok(plantTypesService.getAllPlantTypes());
    }

    @Override
    public ResponseEntity<PlantType> createPlantType(PlantType plantType) {

        return ResponseEntity.ok(plantTypesService.createPlantType(plantType));
    }

    @Override
    public ResponseEntity<PlantType> updatePlantType(PlantType plantType) {

        return ResponseEntity.ok(plantTypesService.updatePlantType(plantType));
    }

    @Override
    public ResponseEntity<Void> deletePlantType(PlantType plantType) {

        return ResponseEntity.ok(plantTypesService.removePlantType(plantType));
    }
}
