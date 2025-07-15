package org.example.repository;

import org.example.Enums;
import org.example.model.PlantDatasheet;
import org.example.model.VegetableDatasheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface PlantDatasheetRepository extends JpaRepository<PlantDatasheet, Long> {
    List<PlantDatasheet> findByPlantType(Enums.PlantType plantType);
    Optional<PlantDatasheet> findByNameAndPlantType(String name, Enums.PlantType plantType);
}
