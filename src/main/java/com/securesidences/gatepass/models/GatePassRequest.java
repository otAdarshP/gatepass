package com.securesidences.gatepass.models;

import ch.qos.logback.core.status.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class GatePassRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(nullable = false)
    private String reason;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @OneToOne(mappedBy = "gatePassRequest", cascade = CascadeType.ALL, orphanRemoval = true)
    private ParentApproval parentApproval;
}