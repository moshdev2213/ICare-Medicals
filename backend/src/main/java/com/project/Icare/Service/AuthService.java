package com.project.Icare.Service;

import com.project.Icare.Collection.Patient;
import com.project.Icare.CollectionDTO.LoginDao;

import java.util.Optional;

public interface AuthService {
	Patient createPatient(Patient patient);
	Optional<Patient> findPatient(String email);
	Optional<LoginDao> loginPatient(String email,String password);
}
