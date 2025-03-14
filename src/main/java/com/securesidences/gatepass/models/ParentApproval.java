package com.securesidences.gatepass.models;

import ch.qos.logback.core.status.Status;
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

public class ParentApproval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn (name = "gate_pass_id", nullable = false)
    private GatePassRequest gatePassRequest;

    @Enumerated (EnumType.STRING)
    @JoinColumn(nullable = false)
    private Status status;

    @Column (nullable = false)
    private String parentRemarks;

}

