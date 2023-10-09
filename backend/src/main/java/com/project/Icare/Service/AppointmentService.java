package com.project.Icare.Service;

import com.project.Icare.Collection.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
	Appointment createAppointment(Appointment appointment);

	Optional<List<Appointment>> getAllAppointments(String email);
}
