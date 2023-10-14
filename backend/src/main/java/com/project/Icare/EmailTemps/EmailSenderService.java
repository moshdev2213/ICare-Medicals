package com.project.Icare.EmailTemps;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendsSimpleEmail(String toEmail, String body, String subject) throws MessagingException {
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true); // true indicates multipart message

		helper.setFrom("ICareMedicals@gmail.com");
		helper.setTo(toEmail);
		helper.setSubject(subject);
		helper.setText(body, true); // true indicates HTML content

		mailSender.send(message);
	}
}
