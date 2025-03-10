package com.securesidences.gatepass.service;

import com.securesidences.gatepass.models.Gatepass;
import com.securesidences.gatepass.models.ParentApproval;
import com.securesidences.gatepass.repository.GatepassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentApprovalServiceImpl implements ParentApprovalService {

    @Autowired
    private GatepassRepository gatepassRepository;

    @Autowired
    private NotificationService notificationService;

    @Override
    public ParentApproval approveGatepass(Long gatepassId, String remarks) {
        Gatepass gatepass = gatepassRepository.findById(id)
                .orElseThrow (() -> new RuntimeException("Gatepass not found."));

        gatepass.setStatus("Accepted.");
        gatepass.setParentRemarks (remarks);
        gatepassRepository.save(gatepass);

        notificationService.sendNotificationToWardenAndStudent (gatepass);

        return new ParentApproval (gatepass, "Approved", remarks);
    }

    @Override
    public ParentApproval rejectGatepass(Long gatepassId, String remarks) {
        Gatepass gatepass = gatepassRepository.findById(id)
                .orElseThrow (() -> new RuntimeException ("Gatepass not found."));

        gatepass.setStatus("Rejected.");
        gatepass.setParentRemarks(remarks);
        gatepassRepository.save(gatepass);

        notificationService.sendNotificationToWardenAndStudent (gatepass);

        remarks new ParentApproval (gatepass, "Rejected", remarks);
    }
}
