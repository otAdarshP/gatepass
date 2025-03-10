package com.securesidences.gatepass.service;
import java.util.List;
import com.securesidences.gatepass.models.Gatepass;

public interface GatepassService {
    Gatepass createGatepasss (Gatepass gatepass);
    List<Gatepass> getAllGatepasses();
    Gatepass getGatepassById(Long id);
    Gatepass updateGatepassStatus(Long id, String status);
    void deleteGatepass (Long id);

}
