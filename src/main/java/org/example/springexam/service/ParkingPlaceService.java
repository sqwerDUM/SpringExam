package org.example.springexam.service;

import org.example.springexam.dto.CreateParkingPlaceDto;
import org.example.springexam.dto.ParkingPlaceDto;

import java.util.List;

public interface ParkingPlaceService {
    CreateParkingPlaceDto createParkingPlaceDto (CreateParkingPlaceDto createParkingPlaceDto);
    ParkingPlaceDto findById (Long id);
    List<ParkingPlaceDto> getAllParkingPlace();
}
