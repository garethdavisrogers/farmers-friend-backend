package org.example.controller;

import org.example.Enums;
import org.example.model.PlantDatasheet;
import org.example.model.VegetableDatasheet;
import org.example.repository.PlantDatasheetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/plant-datasheets")
public class PlantDatasheetController {
    private final PlantDatasheetRepository plantDatasheetRepository;


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
    public ResponseEntity<PlantDatasheet> postNewPlantDatasheet(@RequestBody PlantDatasheet plantDatasheet)
    {
        PlantDatasheet saved = plantDatasheetRepository.save(plantDatasheet);
        return ResponseEntity.status(201).body(saved);
    }

}
