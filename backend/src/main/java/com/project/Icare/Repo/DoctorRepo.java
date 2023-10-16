package com.project.Icare.Repo;

import com.project.Icare.Collection.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DoctorRepo extends MongoRepository<Doctor, String> {
	Optional<List<Doctor>> findByStatus(int status);

	@Query(value = "{ 'specializing' : ?0 }", count = true)
	List<Doctor> countDoctorsBySpecialization(String specialization);

}
