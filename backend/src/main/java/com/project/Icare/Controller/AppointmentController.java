package com.project.Icare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Icare.Collection.Appointment;
import com.project.Icare.Service.AppointmentService;

@RestController
@RequestMapping("/api/appointment")
@CrossOrigin("*")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping("/create")
	public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
		
		Appointment resAppointment = appointmentService.createAppointment(appointment);
		return new ResponseEntity<>(resAppointment, HttpStatus.CREATED);
	}
}
