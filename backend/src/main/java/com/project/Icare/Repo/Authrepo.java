package com.project.Icare.Repo;

import com.project.Icare.Collection.Patient;
import com.project.Icare.CollectionDTO.LoginDao;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface Authrepo extends MongoRepository<Patient, String> {
	Optional<Patient> findByEmail(String email);
	
	Optional<LoginDao> findByEmailAndPassword(String email,String password);
}
