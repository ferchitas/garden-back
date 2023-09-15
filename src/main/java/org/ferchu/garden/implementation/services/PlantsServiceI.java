package org.ferchu.garden.implementation.services;

import org.ferchu.garden.generated.model.Plant;

import java.util.List;

public interface PlantsServiceI {

    public List<Plant> getAllPlants();
    public Plant createPlant(Plant plant);
    Void removePlant(Plant plant);
    Plant updatePlant(Plant plant);
}
