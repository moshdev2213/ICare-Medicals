package com.project.webapp.Controller;


import com.project.webapp.DTO.DoctorSpecializationCountDTO;
import com.project.webapp.Entity.Doctor;
import com.project.webapp.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("api/v1/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    //post/save
    @PostMapping(value = "/save")
    private String saveStudent(@RequestBody Doctor doctors)
    {
        doctorService.saveorUpdate(doctors);
        return doctors.getId();
    }


    @GetMapping(value = "/getAll")
    public Iterable<Doctor> getDoctors() {
        return doctorService.listAll();
    }



    //update
    @PutMapping(value = "/edit/{id}")
    private Doctor update(@RequestBody Doctor doctor,@PathVariable(name = "id")String _id)
    {
        doctor.setId(_id);
        doctorService.saveorUpdate(doctor);
        return doctor;

    }

    //delete
    @DeleteMapping("/delete/{id}")
    private void deleteDoctor(@PathVariable("id") String _id)
    {

        doctorService.deleteDoctor(_id);
    }

    @RequestMapping("/{id}")
    private Doctor getDoctor(@PathVariable(name = "id")String doctorid)
    {
        return doctorService.getDoctorByID(doctorid);
    }
    @PutMapping
    private Doctor modifyDoctor(@RequestBody Doctor doctor){

        return doctorService.updateDoctor(doctor);
    }

    @GetMapping("/api/countDoctorsBySpecialization")
    public List<DoctorSpecializationCountDTO> countDoctorsBySpecialization() {
        List<Doctor> doctors = doctorService.findAllDoctors(); // Fetch all doctors
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
