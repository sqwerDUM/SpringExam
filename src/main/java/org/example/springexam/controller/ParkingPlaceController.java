package org.example.springexam.controller;


import lombok.RequiredArgsConstructor;
import org.example.springexam.dto.ParkingPlaceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Controller
@RequiredArgsConstructor
public class ParkingPlaceController {
    private final ParkingPlaceDto service;
    public ResponseEntity<List<ParkingPlaceDto>> getAll() {
List<ParkingPlaceDto> parkingPlaceDtos = service.ge
    }
}
