package com.project.Icare.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.Icare.Collection.Patient;

public interface Authrepo extends MongoRepository<Patient, String> {

}
