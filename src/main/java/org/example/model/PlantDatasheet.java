package org.example.model;
import jakarta.persistence.*;
import org.example.Enums.PlantType;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;


@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "plantType", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = VegetableDatasheet.class, name = "VEGETABLE")
        // add other types if needed
})
@Entity
@Table(name = "plant_datasheets")
public abstract class PlantDatasheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private PlantType plantType;

    @Lob
    private byte[] image;

    public PlantDatasheet()
    {

    }

    public PlantDatasheet(PlantType plantType)
    {
        this.plantType = plantType;
    }

    public Long getId()
    {
        return id;
    }

    public String getPlantName(){
        return name;
    }

    public PlantType getPlantType()
    {
        return plantType;
    }

    public byte[] getImage()
    {
        return image;
    }

    public void setPlantType(PlantType plantType)
    {
        this.plantType = plantType;
    }

    public void setPlantName(String name)
    {
        this.name = name;
    }

    public void setPlantImage(byte[] image)
    {
        this.image = image;
    }

}
