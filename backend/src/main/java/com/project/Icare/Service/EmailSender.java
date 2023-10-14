package com.project.Icare.Service;

public interface EmailSender {


    void sendEmail(String toEmail,
                   String subject,
                   String body);
}
