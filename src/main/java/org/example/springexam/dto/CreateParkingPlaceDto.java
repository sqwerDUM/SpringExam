package org.example.springexam.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springexam.enums.ParkingStatus;
import org.example.springexam.enums.ParkingType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateParkingPlaceDto {
    private Long id;
    private String place;
    private ParkingStatus status;
    private ParkingType type;
}
