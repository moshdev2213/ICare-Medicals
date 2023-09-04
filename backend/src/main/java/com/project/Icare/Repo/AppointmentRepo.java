package com.project.Icare.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.Icare.Collection.Appointment;
import com.project.Icare.Collection.Doctor;

public interface AppointmentRepo extends MongoRepository<Appointment, String>{
	Optional<List<Appointment>> findByPatEmail(String patEmail);
}
