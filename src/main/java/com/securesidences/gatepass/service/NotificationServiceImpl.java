package com.securesidences.gatepass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendGatepassSubmissionEmail(Gatepass gatepass) {
        String parentEmail = gatepass.getStudent().getParentEmail();
        String subject = "Gate Pass approval request.";
        String body = "Dear Parent, \n\nYour child has submitted a gate pass request.\nClick here to approve/reject.";

        sendEmail (parentEmail, subject, body);
    }

    @Override
    public void sendNotificationToWardenAndStudent(Gatepass gatepass) {
        String studentEmail = gatepass.getStudent().getEmail();
        String wardenEmail = "viveksh271@gmail.com";

        String body = "Gatepass Decision";
        String decision = "The gate pass request has been" + gatepass.getStatus() + ".\nRemarks: " + gatepass.getParentRemarks();

        sendEmail (studentEmail, subject, body);
        sendEmail (studentEmail, subject, body);

    }

    private void sendEmail (String to, String subject, String body){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}
