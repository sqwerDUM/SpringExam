package org.example.springexam.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class ParkingPlaceDto {
    private Long id;
    private String place;
    @Enumerated(EnumType.ORDINAL)
    private ParkingStatus status;
    @Enumerated(EnumType.ORDINAL)
    private ParkingType type;
}

