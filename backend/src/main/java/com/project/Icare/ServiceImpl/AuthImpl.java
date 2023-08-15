package com.project.Icare.ServiceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Icare.Collection.Patient;
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
	
	
}
