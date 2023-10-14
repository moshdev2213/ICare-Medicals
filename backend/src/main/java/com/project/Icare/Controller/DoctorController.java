package com.project.Icare.Controller;

import com.project.Icare.Collection.Doctor;
import com.project.Icare.Exception.ResourceNotFound;
import com.project.Icare.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctor")
@CrossOrigin("*")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@PostMapping("/register")
	public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
		Doctor resDoctor = doctorService.createDoctor(doctor);
		return new ResponseEntity<>(resDoctor, HttpStatus.CREATED);
	}

	@GetMapping("/getAllDoctors/{status}")
	public ResponseEntity<List<Doctor>> getAllActiveDoctors(@PathVariable(value = "status")int status) {
		 Optional<List<Doctor>> docListOptional = doctorService.getAllActiveDoctors(status);  
		
		if (docListOptional.isPresent() && !docListOptional.get().isEmpty()) {
		        List<Doctor> docList = docListOptional.get();
		        return ResponseEntity.ok(docList);
		    } else {
		        throw new ResourceNotFound("No Deactivated Doctors");
		    }
	}
}
