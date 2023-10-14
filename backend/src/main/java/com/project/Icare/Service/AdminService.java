package com.project.Icare.Service;


import java.util.Optional;

import com.project.Icare.Collection.Admin;
import com.project.Icare.CollectionDTO.AloginDto;

public interface AdminService {


    Admin register(Admin admin);

//    Optional<Patient> findPatient(String email);
    Optional<Admin> findAdmin(String email);
//    Optional<LoginDao> loginPatient(String email,String password);
    Optional<AloginDto> loginAdmin(String email,String password);
}
