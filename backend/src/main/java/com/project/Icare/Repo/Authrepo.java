package com.project.Icare.Repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.Icare.Collection.Patient;
import com.project.Icare.CollectionDTO.LoginDao;

public interface Authrepo extends MongoRepository<Patient, String> {
	Optional<Patient> findByEmail(String email);
	
	Optional<LoginDao> findByEmailAndPassword(String email,String password);
}
