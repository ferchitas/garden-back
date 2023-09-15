package org.ferchu.garden.implementation.services;

import org.ferchu.garden.generated.model.Plant;
import org.ferchu.garden.generated.model.PlantType;

import java.util.List;

public interface PlantTypeServiceI {

    public List<PlantType> getAllPlantTypes();
    public PlantType createPlantType(PlantType plantType);
    Void removePlantType(PlantType plantType);
    PlantType updatePlantType(PlantType plantType);
}
