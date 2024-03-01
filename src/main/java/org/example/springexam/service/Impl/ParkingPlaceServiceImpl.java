package org.example.springexam.service.Impl;

import org.example.springexam.dto.CreateParkingPlaceDto;
import org.example.springexam.dto.ParkingPlaceDto;
import org.example.springexam.entity.ParkingSpace;
import org.example.springexam.repo.ParkingPlaceRepo;
import org.example.springexam.service.ParkingPlaceService;

import java.sql.Date;

public class ParkingPlaceServiceImpl implements ParkingPlaceService {
    private final ParkingPlaceRepo repo;

    @Override
    public CreateParkingPlaceDto createParkingPlace(ParkingPlaceDto parkingPlaceDto) {

        ParkingSpace productToSave = ParkingSpace.builder()
                .place(ParkingPlaceDto.ge)




    }
}
