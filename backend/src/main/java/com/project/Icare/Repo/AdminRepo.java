package com.project.Icare.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.Icare.Collection.Admin;
import com.project.Icare.CollectionDTO.AloginDto;

import java.util.Optional;

public interface AdminRepo extends MongoRepository<Admin,String> {

    Optional<Admin> findByEmail(String email);

    Optional<AloginDto> findByEmailAndPassword(String email, String password);


}
