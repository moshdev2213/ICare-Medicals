package com.project.webapp.Service;

public interface EmailSender {


    void sendEmail(String toEmail,
                   String subject,
                   String body);
}
