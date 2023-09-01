package com.project.Icare.Service;

import java.util.List;
import java.util.Optional;

import com.project.Icare.Collection.Doctor;

public interface DoctorService {
	Doctor createDoctor(Doctor doctor);
	Optional<List<Doctor>> getAllActiveDoctors(int status);
}
