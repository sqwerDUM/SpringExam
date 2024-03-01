package org.example.springexam.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springexam.enums.ParkingStatus;
import org.example.springexam.enums.ParkingType;

import java.sql.Date;
@Table
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String place;
    @Enumerated(EnumType.ORDINAL)
    private ParkingStatus status;
    @Enumerated(EnumType.ORDINAL)
    private ParkingType type;
}


