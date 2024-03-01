package org.example.springexam.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springexam.enums.ParkingSpaceStatus;
import org.example.springexam.enums.ParkingSpaceType;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "parking_space")
public class ParkingSpace {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "space_number")
        private String spaceNumber;

        @Enumerated(EnumType.STRING)
        @Column(name = "status")
        private ParkingSpaceStatus status;

        @Enumerated(EnumType.STRING)
        @Column(name = "type")
        private ParkingSpaceType type;
    }


