package com.project.Icare.ServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Icare.Collection.Appointment;
import com.project.Icare.EmailTemps.EmailTransaction;
import com.project.Icare.EmailTemps.SMSAppointment;
import com.project.Icare.EmailTemps.SendLkSms;
import com.project.Icare.Repo.AppointmentRepo;
import com.project.Icare.Repo.DoctorRepo;
import com.project.Icare.Service.AppointmentService;

import jakarta.mail.MessagingException;

@Service
public class AppointmentImpl implements AppointmentService {
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
	String formattedDate = dateFormat.format(new Date());
	
	@Autowired
	private AppointmentRepo appointmentRepo;
	
	@Autowired
	private EmailTransaction emailTransaction;
	
	@Autowired
	private SendLkSms sendLkSms;
	
	@Override
	public Appointment createAppointment(Appointment appointment) {
		appointment.setAdded(formattedDate);
		Appointment appointmentRes = appointmentRepo.save(appointment);
		
		try {
			emailTransaction.sendHtmlEmail(appointment.getPatEmail(), 
					"ICare Appointments",
					Integer.toString(appointment.getReference()),
					appointment.getDate(),
					"Dr. "+appointment.getDocName().toUpperCase(),
					"Mr. "+appointment.getPatName().toUpperCase(),
					Double.toString(appointment.getAmount()),
					Double.toString(appointment.getAmount()),
					appointment.getTime(),
					appointment.getVenue()
			);
			if (!(appointment.getPatNumber()==null)) {
				sendLkSms.sendSms(appointment.getPatNumber(),SMSAppointment.msg(appointmentRes));
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return appointmentRes;
	}

}
