package com.securesidences.gatepass.service;

import com.securesidences.gatepass.models.ParentApproval;

public interface ParentApprovalService {
    ParentApproval approveGatepass (Long gatepassId, String remarks);
    ParentApproval rejectGatepass (Long gatepassId, String remarks);
}
