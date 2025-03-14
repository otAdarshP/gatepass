package com.securesidences.gatepass.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @OneToMany (mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    List<GatePassRequest> gatePassRequests;

}