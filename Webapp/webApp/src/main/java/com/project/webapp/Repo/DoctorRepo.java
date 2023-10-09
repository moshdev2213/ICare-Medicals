package com.project.webapp.Repo;


import com.project.webapp.Entity.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepo extends MongoRepository<Doctor,String> {
}
