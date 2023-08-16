package com.project.Icare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Icare.Collection.Patient;
import com.project.Icare.CollectionDTO.LoginDao;
import com.project.Icare.Exception.ResourceNotFound;
import com.project.Icare.Service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/register/patient")
	public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
		Patient resPatient =  authService.createPatient(patient);
		return new ResponseEntity<>(resPatient,HttpStatus.CREATED); 
	}
	
	@GetMapping("/exist/patient/{email}")
	public ResponseEntity<Patient> findPatient(@PathVariable(value = "email") String email){
		Patient resPatient = authService.findPatient(email).orElseThrow(
				()->new ResourceNotFound("Patient Not exist with Email " +email)
		);
		return ResponseEntity.ok(resPatient);
	}
	
	@PostMapping("/login/patient")
	public ResponseEntity<LoginDao> loginPatient(@RequestBody LoginDao loginDao){
		LoginDao logRes = authService.loginPatient(loginDao.getEmail(), loginDao.getPassword()).orElseThrow(
				()->new ResourceNotFound("mail And Password Error")
		);
		return ResponseEntity.ok(logRes);	
	}
}
