package com.project.Icare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Icare.Collection.Doctor;
import com.project.Icare.Service.DoctorService;

@RestController
@RequestMapping("/api/doctor")
@CrossOrigin("*")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/register")
	public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor){
		Doctor resDoctor =  doctorService.createDoctor(doctor);
		return new ResponseEntity<>(resDoctor,HttpStatus.CREATED); 
	}
}
