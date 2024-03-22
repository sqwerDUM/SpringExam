package org.example.springexam.service;

import org.example.springexam.dto.ParkingSpaceCreateRequestDto;
import org.example.springexam.dto.ParkingSpaceDto;
import org.example.springexam.entity.ParkingSpace;
import org.example.springexam.enums.ParkingSpaceType;

import java.util.List;
import java.util.Optional;

public interface ParkingSpaceService {
    List<ParkingSpaceDto> getAllParkingSpaces();

    Optional<ParkingSpaceDto> getParkingSpaceById(Long id);

    ParkingSpaceDto reserveParkingSpace(Long id);
    ParkingSpaceDto createParkingSpace (ParkingSpaceCreateRequestDto requestDto);

    ParkingSpaceDto releaseParkingSpace(Long id);
    List<ParkingSpaceDto> getParkingSpacesByType(ParkingSpaceType type);
    Boolean deleteParkingSpace (Long id);
}
