package com.project.Icare.Service;

import java.util.List;
import java.util.Optional;

import com.project.Icare.Collection.Appointment;
import com.project.Icare.Collection.Doctor;

public interface AppointmentService {
	Appointment createAppointment(Appointment appointment);

	Optional<List<Appointment>> getAllAppointments(String email);
}
