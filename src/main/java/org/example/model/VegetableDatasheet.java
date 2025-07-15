package org.example.model;

import jakarta.persistence.*;
import org.example.Enums.PlantType;
import org.example.Enums.VegetableType;
@Entity
@Table(name = "vegetable_datasheets")
public class VegetableDatasheet extends PlantDatasheet {

    @Enumerated(EnumType.STRING)
    private VegetableType vegetableType;
    private Float idealEC;
    private Float idealPH;
    private int averageDaysToGerminate;
    private int averageDaysToMorphogenesis;

    public VegetableDatasheet()
    {
        super(PlantType.VEGETABLE);
    }

    //getters
    public VegetableType getVegetableType()
    {
        return this.vegetableType;
    }

    public Float getIdealEC() {
        return idealEC;
    }

    public Float getIdealPH() {
        return idealPH;
    }

    public int getAverageDaysToGerminate()
    {
        return  averageDaysToGerminate;
    }

    public int getAverageDaysToMorphogenesis()
    {
        return averageDaysToMorphogenesis;
    }

    //setters
    public void setVegetableType(VegetableType vegetableType)
    {
        this.vegetableType = vegetableType;
    }

    public void setIdealEC(Float idealEC)
    {
        this.idealEC = idealEC;
    }

    public void setIdealPH(Float idealPH)
    {
        this.idealPH = idealPH;
    }

    public void setAverageDaysToGerminate(int averageDaysToGerminate)
    {
        this.averageDaysToGerminate = averageDaysToGerminate;
    }

    public void setAverageDaysToMorphogenesis(int averageDaysToMorphogenesis) {
        this.averageDaysToMorphogenesis = averageDaysToMorphogenesis;
    }
}
