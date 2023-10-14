package com.project.Icare.Service;

import com.project.Icare.Collection.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
	Doctor createDoctor(Doctor doctor);
	Optional<List<Doctor>> getAllActiveDoctors(int status);
}
