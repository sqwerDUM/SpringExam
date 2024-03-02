package org.example.springexam.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import org.example.springexam.dto.ParkingSpaceDto;
import org.example.springexam.dto.ReservationRequestDto;
import org.example.springexam.enums.ParkingSpaceType;
import org.example.springexam.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/parking")
public class ParkingSpaceController {

    @Autowired
    private ParkingSpaceService parkingSpaceService;

@ApiOperation("GET")
    @GetMapping("/spaces")
    public ResponseEntity<List<ParkingSpaceDto>> getAllParkingSpaces() {
        List<ParkingSpaceDto> parkingSpaces = parkingSpaceService.getAllParkingSpaces();
        return ResponseEntity.ok(parkingSpaces);
    }
    @ApiOperation("GET")
    @GetMapping("/spaces/{id}")
    public ResponseEntity<ParkingSpaceDto> getParkingSpaceById(@PathVariable Long id) {
        Optional<ParkingSpaceDto> parkingSpaceDto = parkingSpaceService.getParkingSpaceById(id);
        return parkingSpaceDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @ApiOperation("POST")
    @PostMapping("/reserve")
    public ResponseEntity<ParkingSpaceDto> reserveParkingSpace(@RequestBody ReservationRequestDto reservationRequestDto) {
        ParkingSpaceDto reservedSpace = parkingSpaceService.reserveParkingSpace(reservationRequestDto.getParkingSpaceId());
        return reservedSpace != null ? ResponseEntity.ok(reservedSpace) : ResponseEntity.badRequest().build();
    }
    @ApiOperation("PUT")
    @PutMapping("/release/{id}")
    public ResponseEntity<ParkingSpaceDto> releaseParkingSpace(@PathVariable Long id) {
        ParkingSpaceDto releasedSpace = parkingSpaceService.releaseParkingSpace(id);
        return releasedSpace != null ? ResponseEntity.ok(releasedSpace) : ResponseEntity.badRequest().build();
    }
    @ApiOperation("GET")
    @GetMapping("/spaces/type/{type}")
    public ResponseEntity<List<ParkingSpaceDto>> getParkingSpacesByType(@PathVariable ParkingSpaceType type) {
        List<ParkingSpaceDto> parkingSpaces = parkingSpaceService.getParkingSpacesByType(type);
        return ResponseEntity.ok(parkingSpaces);
    }
}
