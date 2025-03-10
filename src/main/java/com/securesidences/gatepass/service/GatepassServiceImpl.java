package com.securesidences.gatepass.service;

import com.securesidences.gatepass.models.Gatepass;
import com.securesidences.gatepass.repository.GatepassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GatepassServiceImpl implements GatepassService {

    @Autowired
    private GatepassRepository gatepassRepository;

    @Override
    public Gatepass createGatepasss(Gatepass gatepass) {
        return gatepassRepository.save(gatepass);
    }

    @Override
    public List<Gatepass> getAllGatepasses() {
        return gatepassRepository.findAll();
    }

    @Override
    public Gatepass getGatepassById(Long id) {
        return gatepassRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gatepass not found."));
    }

    @Override
    public Gatepass updateGatepassStatus(Long id, String status) {
        Gatepass gatepass = getGatepassById(id);
        gatepass.setStatus(status);
        return gatepassRepository.save(gatepass);
    }

    @Override
    public void deleteGatepass(Long id) {
        gatepassRepository.deleteByID(id);
    }
}
