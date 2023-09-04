package com.project.Icare.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Icare.Collection.Appointment;
import com.project.Icare.Collection.Doctor;
import com.project.Icare.Exception.ResourceNotFound;
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

	@GetMapping("/getAllAppointments/{email}")
	public ResponseEntity<List<Appointment>> getAllAppointments(@PathVariable(value = "email") String email) {
		Optional<List<Appointment>> appoListOptional = appointmentService.getAllAppointments(email);

		if (appoListOptional.isPresent() && !appoListOptional.get().isEmpty()) {
			List<Appointment> appoList = appoListOptional.get();
			return ResponseEntity.ok(appoList);
		} else {
			throw new ResourceNotFound("No Appointments Found");
		}
	}
}
