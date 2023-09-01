package com.project.Icare.ServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Icare.Collection.Doctor;
import com.project.Icare.Repo.DoctorRepo;
import com.project.Icare.Service.DoctorService;

@Service
public class DoctorImpl implements DoctorService {

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
	String formattedDate = dateFormat.format(new Date());

	@Autowired
	private DoctorRepo doctorRepo;

	@Override
	public Doctor createDoctor(Doctor doctor) {
		doctor.setAdded(formattedDate);
		Doctor doctorRes = doctorRepo.save(doctor);
		return doctorRes;
	}

	@Override
	public Optional<List<Doctor>> getAllActiveDoctors(int status) {
		return doctorRepo.findByStatus(status);
	}

}
