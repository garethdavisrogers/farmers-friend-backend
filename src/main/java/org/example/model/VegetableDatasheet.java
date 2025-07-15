package org.example.model;

import jakarta.persistence.*;
import org.example.Enums.PlantType;
import org.example.Enums.VegetableType;
@Entity
@Table(name = "vegetable_datasheets")
public class VegetableDatasheet extends PlantDatasheet {

    @Enumerated(EnumType.STRING)
    private VegetableType type;
    private Float idealEC;
    private Float idealPH;
    private int averageDaysToGerminate;
    private int averageDaysToMorphogenesis;

    public VegetableDatasheet()
    {
        super(PlantType.VEGETABLE);
    }

    public VegetableDatasheet(VegetableType type, String name, Float idealEC, Float idealPH, int averageDaysToGerminate, int averageDaysToMorphogenesis, byte[] image) {
        super(PlantType.VEGETABLE);
        this.type = type;
        this.setPlantName(name);
        this.idealEC = idealEC;
        this.idealPH = idealPH;
        this.averageDaysToGerminate = averageDaysToGerminate;
        this.averageDaysToMorphogenesis = averageDaysToMorphogenesis;
        this.setImage(image);
    }

    public VegetableType getType()
    {
        return this.type;
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

    public void setType(VegetableType type)
    {
        this.type = type;
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
