package com.project.webapp.Repo;

import com.project.webapp.DTO.AloginDto;
import com.project.webapp.Entity.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AdminRepo extends MongoRepository<Admin,String> {

    Optional<Admin> findByEmail(String email);

    Optional<AloginDto> findByEmailAndPassword(String email, String password);


}
