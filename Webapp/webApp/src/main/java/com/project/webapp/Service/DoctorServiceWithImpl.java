package com.project.webapp.Service;


import com.project.webapp.Entity.Doctor;
import com.project.webapp.Repo.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceWithImpl {

    @Autowired
    private DoctorRepo repo;

    public void saveorUpdate(Doctor doctors) {

        repo.save(doctors);
    }

    public Iterable<Doctor> listAll() {

        return this.repo.findAll();
    }

    public void deleteDoctor(String id) {

        repo.deleteById(id);
    }

    public Doctor getDoctorByID(String doctorid) {

        return repo.findById(doctorid).get();
    }

    public Doctor updateDoctor(Doctor doctorRequest) {

        Doctor existing = repo.findById(doctorRequest.getId()).orElse(null);

        if (existing!=null){
            existing.setFirstName(doctorRequest.getFirstName());
            existing.setLastName(doctorRequest.getLastName());
            existing.setEmail(doctorRequest.getEmail());
            existing.setVenue(doctorRequest.getVenue());
            existing.setTimeAvailabe(doctorRequest.getTimeAvailabe());
            existing.setSpecializing(doctorRequest.getSpecializing());
            existing.setDescription(doctorRequest.getDescription());
            existing.setStatus(doctorRequest.getStatus());
            existing.setAmount(doctorRequest.getAmount());
            existing.setCured(doctorRequest.getCured());
            existing.setVenue(doctorRequest.getVenue());
            existing.setAdded(doctorRequest.getAdded());
            existing.setEdited(doctorRequest.getEdited());

            return repo.save(existing);
        }
        return null;
    }

    public List<Doctor> findAllDoctors() {
        return repo.findAll();
    }

}
