package com.project.Icare.Controller;

import com.project.Icare.Collection.Doctor;
import com.project.Icare.CollectionDTO.DoctorSpecializationCountDTO;
import com.project.Icare.Exception.ResourceNotFound;
import com.project.Icare.Service.DoctorService;
import com.project.Icare.Service.DoctorServiceWithImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/doctor")
@CrossOrigin("*")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	 @Autowired
	    private DoctorServiceWithImpl doctorServiceWithImpl;

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
	
	//post/save
    @PostMapping(value = "/save")
    private String saveStudent(@RequestBody Doctor doctors)
    {
    	doctorServiceWithImpl.saveorUpdate(doctors);
        return doctors.getId();
    }


    @GetMapping(value = "/getAll")
    public Iterable<Doctor> getDoctors() {
        return doctorServiceWithImpl.listAll();
    }



    //update
    @PutMapping(value = "/edit/{id}")
    private Doctor update(@RequestBody Doctor doctor,@PathVariable(name = "id")String _id)
    {
        doctor.setId(_id);
        doctorServiceWithImpl.saveorUpdate(doctor);
        return doctor;

    }

    //delete
    @DeleteMapping("/delete/{id}")
    private void deleteDoctor(@PathVariable("id") String _id)
    {

    	doctorServiceWithImpl.deleteDoctor(_id);
    }

    @RequestMapping("/{id}")
    private Doctor getDoctor(@PathVariable(name = "id")String doctorid)
    {
        return doctorServiceWithImpl.getDoctorByID(doctorid);
    }
    @PutMapping
    private Doctor modifyDoctor(@RequestBody Doctor doctor){

        return doctorServiceWithImpl.updateDoctor(doctor);
    }

    @GetMapping("/api/countDoctorsBySpecialization")
    public List<DoctorSpecializationCountDTO> countDoctorsBySpecialization() {
        List<Doctor> doctors = doctorServiceWithImpl.findAllDoctors(); // Fetch all doctors
        List<DoctorSpecializationCountDTO> specializationCounts = new ArrayList<>();

        // Group doctors by specialization and count them
        Map<String, Long> counts = doctors.stream()
                .collect(Collectors.groupingBy(Doctor::getSpecializing, Collectors.counting()));

        // Convert counts to DTOs
        counts.forEach((specialization, count) -> {
            specializationCounts.add(new DoctorSpecializationCountDTO(specialization, count));
        });

        return specializationCounts;
    }
	
}
