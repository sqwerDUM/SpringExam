package org.example.springexam.service.Impl;

import org.example.springexam.dto.ParkingSpaceCreateRequestDto;
import org.example.springexam.entity.ParkingSpace;
import org.example.springexam.dto.ParkingSpaceDto;
import org.example.springexam.enums.ParkingSpaceStatus;
import org.example.springexam.enums.ParkingSpaceType;
import org.example.springexam.repo.ParkingSpaceRepo;
import org.example.springexam.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParkingSpaceServiceImpl implements ParkingSpaceService {
    @Autowired
    public ParkingSpaceRepo parkingSpaceRepo;

    @Override
    public List<ParkingSpaceDto> getAllParkingSpaces() {
        List<ParkingSpace> parkingSpaces = parkingSpaceRepo.findAll();
        return parkingSpaces.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ParkingSpaceDto> getParkingSpaceById(Long id) {
        Optional<ParkingSpace> optionalParkingSpace = parkingSpaceRepo.findById(id);
        return optionalParkingSpace.map(this::convertToDto);
    }

    @Override
    public ParkingSpaceDto reserveParkingSpace(Long id) {
            Optional<ParkingSpace> optionalParkingSpace = parkingSpaceRepo.findById(id);
            if (optionalParkingSpace.isPresent()) {
                ParkingSpace parkingSpace = optionalParkingSpace.get();
                if (parkingSpace.getStatus() == ParkingSpaceStatus.FREE) {
                    ParkingSpace newParkingSpace = new ParkingSpace();
                    newParkingSpace.setSpaceNumber(parkingSpace.getSpaceNumber());
                    newParkingSpace.setType(parkingSpace.getType());
                    newParkingSpace.setStatus(ParkingSpaceStatus.OCCUPIED);
                    ParkingSpace updatedParkingSpace = parkingSpaceRepo.save(newParkingSpace);
                    return convertToDto(updatedParkingSpace);
                }
            }
            return null;
        }



    @Override
    public ParkingSpaceDto releaseParkingSpace(Long id) {
        Optional<ParkingSpace> optionalParkingSpace = parkingSpaceRepo.findById(id);
        if (optionalParkingSpace.isPresent()) {
            ParkingSpace parkingSpace = optionalParkingSpace.get();
            if (parkingSpace.getStatus() == ParkingSpaceStatus.OCCUPIED) {
                parkingSpace.setStatus(ParkingSpaceStatus.FREE);
                ParkingSpace updatedParkingSpace = parkingSpaceRepo.save(parkingSpace);
                return convertToDto(updatedParkingSpace);
            }
        }
        return null;
    }

    public ParkingSpaceDto createParkingSpace(ParkingSpaceCreateRequestDto requestDto) {
        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setLocation(requestDto.getLocation());
        parkingSpace.setReserved(false);
        ParkingSpace savedParkingSpace = parkingSpaceRepo.save(parkingSpace);
        return new ParkingSpaceDto(savedParkingSpace.getId(), savedParkingSpace.getLocation());
    }



    private ParkingSpaceDto convertToDto(ParkingSpace parkingSpace) {
        ParkingSpaceDto dto = new ParkingSpaceDto();
        dto.setId(parkingSpace.getId());
        dto.setSpaceNumber(parkingSpace.getSpaceNumber());
        dto.setStatus(parkingSpace.getStatus());
        return dto;
    }

    @Override
    public List<ParkingSpaceDto> getParkingSpacesByType(ParkingSpaceType type) {
        List<ParkingSpace> parkingSpaces = parkingSpaceRepo.findByType(type);
        return parkingSpaces.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteParkingSpace(Long id) {
        Optional<ParkingSpace> optionalParkingSpace = parkingSpaceRepo.findById(id);
        if (optionalParkingSpace.isPresent()) {
            parkingSpaceRepo.deleteById(id);
            return true;
        }
        return false;
    }
}