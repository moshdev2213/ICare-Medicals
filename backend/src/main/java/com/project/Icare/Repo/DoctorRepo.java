package com.project.Icare.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.Icare.Collection.Doctor;
import java.util.List;
import java.util.Optional;


public interface DoctorRepo extends MongoRepository<Doctor, String> {
	Optional<List<Doctor>> findByStatus(int status);

}
