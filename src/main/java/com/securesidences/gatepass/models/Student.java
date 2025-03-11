package com.securesidences.gatepass.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    private Long id;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false)
    private int roomNo;

    @Column (nullable = false)
    private String leaveDate;

    @Column (nullable = false)
    private String returnDate;

    @Column (nullable = false)
    private String travelAddress;

    @Column (nullable = false)
    private int phoneNo;
}