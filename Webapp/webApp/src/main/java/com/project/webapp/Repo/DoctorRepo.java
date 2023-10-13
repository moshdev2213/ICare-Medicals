package com.project.webapp.Repo;


import com.project.webapp.Entity.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface DoctorRepo extends MongoRepository<Doctor,String> {

    @Query(value="{ 'specializing' : ?0 }", count = true)
    List<Doctor> countDoctorsBySpecialization(String specialization);
}
