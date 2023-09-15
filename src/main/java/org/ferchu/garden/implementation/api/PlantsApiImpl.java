package org.ferchu.garden.implementation.api;

import org.ferchu.garden.generated.api.PlantsApiDelegate;
import org.ferchu.garden.generated.model.Plant;
import org.ferchu.garden.implementation.services.PlantsServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlantsApiImpl implements PlantsApiDelegate {

    @Autowired
    PlantsServiceI plantsService;

    @Override
    public ResponseEntity<List<Plant>> getAllPlants() {

        return ResponseEntity.ok(plantsService.getAllPlants());
    }

    @Override
    public ResponseEntity<Plant> createPlant(Plant plant) {
        return ResponseEntity.ok(plantsService.createPlant(plant));
    }

    @Override
    public ResponseEntity<Plant> updatePlant(Plant plant) {

        return ResponseEntity.ok(plantsService.updatePlant(plant));
    }

    @Override
    public ResponseEntity<Void> deletePlant(Plant plant) {
        return ResponseEntity.ok(plantsService.removePlant(plant));
    }
}
