package org.example.model;

import org.example.Enums;

public abstract class PlantDatasheetBuilder<T extends PlantDatasheet, B extends PlantDatasheetBuilder<T,B>> {
    protected final T plant;

    PlantDatasheetBuilder(T plant, Enums.PlantType plantType)
    {
        this.plant = plant;
        this.plant.setPlantType(plantType);
    }

    public B withName(String name)
    {
        plant.setPlantName(name);
        return self();
    }

    public B withImage(byte[] image)
    {
        plant.setPlantImage(image);
        return self();
    }

    public T build()
    {
        return plant;
    }

    protected abstract B self();
}
