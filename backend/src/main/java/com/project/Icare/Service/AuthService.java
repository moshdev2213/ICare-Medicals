package com.project.Icare.Service;

import java.util.Optional;

import com.project.Icare.Collection.Patient;
import com.project.Icare.CollectionDao.LoginDao;

public interface AuthService {
	Patient createPatient(Patient patient);
	Optional<Patient> findPatient(String email);
	Optional<LoginDao> loginPatient(String email,String password);
}
