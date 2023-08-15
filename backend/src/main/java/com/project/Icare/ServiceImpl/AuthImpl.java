package com.project.Icare.ServiceImpl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Icare.Collection.Patient;
import com.project.Icare.CollectionDao.LoginDao;
import com.project.Icare.Repo.Authrepo;
import com.project.Icare.Service.AuthService;

@Service
public class AuthImpl implements AuthService{
	@Autowired
	private Authrepo authrepo;

	@Override
	public Patient createPatient(Patient patient) {
		
		
		Patient resPatient = authrepo.save(patient);
		return resPatient;
	}

	@Override
	public Optional<Patient> findPatient(String email){
		Optional<Patient> resPatient = authrepo.findByEmail(email);
		return resPatient;
	}

	@Override
	public Optional<LoginDao> loginPatient(String email, String password) {
		Optional<LoginDao> resLoginOptional = authrepo.findByEmailAndPassword(email, password);
		return resLoginOptional;
	}
	
	
}
