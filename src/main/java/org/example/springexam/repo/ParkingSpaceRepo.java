package org.example.springexam.repo;

import org.example.springexam.entity.ParkingSpace;
import org.example.springexam.enums.ParkingSpaceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParkingSpaceRepo extends JpaRepository<ParkingSpace, Long> {

    List<ParkingSpace> findAll();
    Optional<ParkingSpace> findById(Long id);
    ParkingSpace save(ParkingSpace parkingSpace);
    List<ParkingSpace> findByType(ParkingSpaceType type);
}
