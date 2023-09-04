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

	
	public static void main(String[] args) {
		SpringApplication.run(IcareApplication.class, args);
	}
	

}
