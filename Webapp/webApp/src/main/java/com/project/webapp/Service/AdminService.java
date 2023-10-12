package com.project.webapp.Service;

import com.project.webapp.DTO.AloginDto;
import com.project.webapp.Entity.Admin;
import com.project.webapp.Entity.Patient;

import java.util.Optional;

public interface AdminService {


    Admin register(Admin admin);

//    Optional<Patient> findPatient(String email);
    Optional<Admin> findAdmin(String email);
//    Optional<LoginDao> loginPatient(String email,String password);
    Optional<AloginDto> loginAdmin(String email,String password);
}
