package org.example.model;

import org.example.Enums;

public class VegetableDatasheetBuilder extends PlantDatasheetBuilder<VegetableDatasheet, VegetableDatasheetBuilder>{
    public VegetableDatasheetBuilder()
    {
        super(new VegetableDatasheet(), Enums.PlantType.VEGETABLE);
    }

    public VegetableDatasheetBuilder withVegetableType(Enums.VegetableType vegetableType)
    {
        plant.setVegetableType(vegetableType);
        return this;
    }

    public VegetableDatasheetBuilder withIdealEC(float idealEC)
    {
        plant.setIdealEC(idealEC);
        return this;
    }

    public VegetableDatasheetBuilder withIdealPH(float idealPH)
    {
        plant.setIdealPH(idealPH);
        return this;
    }

    public VegetableDatasheetBuilder withDaysToGerminate(int averageDaysToGerminate)
    {
        plant.setAverageDaysToGerminate(averageDaysToGerminate);
        return this;
    }

    public VegetableDatasheetBuilder withDaysToMorphogenesis(int averageDaysToMorphogenesis)
    {
        plant.setAverageDaysToMorphogenesis(averageDaysToMorphogenesis);
        return this;
    }

    @Override
    public VegetableDatasheetBuilder self()
    {
        return this;
    }
}
