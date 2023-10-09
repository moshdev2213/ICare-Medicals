package com.project.Icare.Repo;

import com.project.Icare.Collection.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepo extends MongoRepository<Appointment, String>{
	Optional<List<Appointment>> findByPatEmail(String patEmail);
}
