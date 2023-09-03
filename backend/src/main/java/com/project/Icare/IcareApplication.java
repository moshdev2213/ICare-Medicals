package com.project.Icare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.project.Icare.EmailTemps.EmailTransaction;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class IcareApplication {

	@Autowired
	private EmailTransaction emailTransaction;
	
	public static void main(String[] args) {
		SpringApplication.run(IcareApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		emailTransaction.sendHtmlEmail("moshdev2213@gmail.com", "ICare Appointments", "3424443252", "2023.10.10", "Dr. Sunil", "Mr. Silva", " 2500.00", "2500.00");
	}

}
