package org.example.springexam.repo;

import org.example.springexam.entity.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParkingPlaceRepo extends JpaRepository<ParkingPlaceRepo, Long> {

    ParkingSpace findByDeleteDateIsNullAndId(Long id);

    List<ParkingSpace> findAllByDeleteDateIsNull();

    List<ParkingSpace> findAllByDeleteDateIsNullAndManufacturerId(Long id);


}
