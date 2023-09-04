package com.project.Icare.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.Icare.Collection.Appointment;

public interface AppointmentRepo extends MongoRepository<Appointment, String>{

}
