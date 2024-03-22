package org.example.springexam.controller;



import org.example.springexam.dto.ParkingSpaceCreateRequestDto;
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


    @GetMapping("/spaces")
    public ResponseEntity<List<ParkingSpaceDto>> getAllParkingSpaces() {
        List<ParkingSpaceDto> parkingSpaces = parkingSpaceService.getAllParkingSpaces();
        return ResponseEntity.ok(parkingSpaces);
    }

    @GetMapping("/spaces/{id}")
    public ResponseEntity<ParkingSpaceDto> getParkingSpaceById(@PathVariable Long id) {
        Optional<ParkingSpaceDto> parkingSpaceDto = parkingSpaceService.getParkingSpaceById(id);
        return parkingSpaceDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/reserve")
    public ResponseEntity<ParkingSpaceDto> reserveParkingSpace(@RequestBody ReservationRequestDto reservationRequestDto) {
        ParkingSpaceDto reservedSpace = parkingSpaceService.reserveParkingSpace(reservationRequestDto.getParkingSpaceId());
        return reservedSpace != null ? ResponseEntity.ok(reservedSpace) : ResponseEntity.badRequest().build();
    }

    @PostMapping("/create")
    public ResponseEntity<ParkingSpaceDto> createParkingSpace(@RequestBody ParkingSpaceCreateRequestDto requestDto) {
        ParkingSpaceDto createdParkingSpace = parkingSpaceService.createParkingSpace(requestDto);
        return ResponseEntity.ok(createdParkingSpace);
    }

    @PutMapping("/release/{id}")
    public ResponseEntity<ParkingSpaceDto> releaseParkingSpace(@PathVariable Long id) {
        ParkingSpaceDto releasedSpace = parkingSpaceService.releaseParkingSpace(id);
        return releasedSpace != null ? ResponseEntity.ok(releasedSpace) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/spaces/type/{type}")
    public ResponseEntity<List<ParkingSpaceDto>> getParkingSpacesByType(@PathVariable ParkingSpaceType type) {
        List<ParkingSpaceDto> parkingSpaces = parkingSpaceService.getParkingSpacesByType(type);
        return ResponseEntity.ok(parkingSpaces);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteParkingSpace(@PathVariable Long id) {
        boolean deleted = parkingSpaceService.deleteParkingSpace(id);
        if (deleted) {
            return ResponseEntity.ok("Парковочное место с ID " + id + " успешно удалено");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
