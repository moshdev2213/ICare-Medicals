package com.project.Icare.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.Icare.Collection.Doctor;

public interface DoctorRepo extends MongoRepository<Doctor, String> {

}
