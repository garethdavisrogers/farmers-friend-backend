package org.example.controller;

import org.example.Enums;
import org.example.model.PlantDatasheet;
import org.example.model.VegetableDatasheet;
import org.example.model.VegetableDatasheetBuilder;
import org.example.repository.PlantDatasheetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/plant-datasheets")
public class PlantDatasheetController {
    private final PlantDatasheetRepository plantDatasheetRepository;

    public static class VegetableDatasheetRequest {
        public String plantName;
        public String type;
        public Float idealPH;
        public Float idealEC;
        public Integer averageDaysToGerminate;
        public Integer averageDaysToMorphogenesis;
        public byte[] image;
    }

    public PlantDatasheetController(PlantDatasheetRepository plantDatasheetRepository)
    {
        this.plantDatasheetRepository = plantDatasheetRepository;
    }

    @GetMapping("/vegetables")
    public List<PlantDatasheet> getAllVegetables()
    {
        return plantDatasheetRepository.findByPlantType(Enums.PlantType.VEGETABLE);
    }

    @GetMapping("/vegetables/{name}")
    public ResponseEntity<PlantDatasheet> getVegetableByName(@PathVariable String name)
    {
        return plantDatasheetRepository.findByNameAndPlantType(name, Enums.PlantType.VEGETABLE)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PlantDatasheet> postNewPlantDatasheet(@RequestBody VegetableDatasheetRequest req)
    {
        VegetableDatasheet veg = new VegetableDatasheetBuilder()
                .withName(req.plantName)
                .withVegetableType(Enums.VegetableType.valueOf(req.type))
                .withIdealEC(req.idealEC)
                .withIdealPH(req.idealPH)
                .withDaysToGerminate(req.averageDaysToGerminate)
                .withDaysToMorphogenesis(req.averageDaysToMorphogenesis)
                .withImage(req.image)
                .build();

        PlantDatasheet saved = plantDatasheetRepository.save(veg);
        return ResponseEntity.status(201).body(saved);
    }

}
