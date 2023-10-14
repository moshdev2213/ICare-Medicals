package com.project.webapp.ServiceImpl;

import com.project.webapp.Service.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderImpl implements EmailSender {
    @Autowired
    private JavaMailSender mailSender;


    @Override
    public void sendEmail(String toEmail, String subject, String body) {


        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("nisaltharindu3@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);

        System.out.println("Email sent successfully");
    }
}
