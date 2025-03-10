package com.securesidences.gatepass.service;

public interface NotificationService {

    void sendGatepassSubmissionEmail (Gatepass gatepass);
    void sendNotificationToWardenAndStudent (Gatepass gatepass);

}
