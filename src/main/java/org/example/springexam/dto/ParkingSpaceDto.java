package org.example.springexam.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springexam.enums.ParkingSpaceStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingSpaceDto {
    private Long id;
    private String spaceNumber;
    private ParkingSpaceStatus status;
}

