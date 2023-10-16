package com.project.Icare.Service;

import java.util.List;

import java.util.Map;

import com.project.Icare.Collection.Patient;
import com.project.Icare.CollectionDTO.RegistrationDataDto;

public interface patientService {
	Patient addPatient(Patient patient);

	List<Patient> getPatients();

	Patient getPatientById(String pid);

	Patient updatePatient(Patient patientRequest);

	String deletePatient(String patientId);

	Map<String, RegistrationDataDto> getRegistrationData(int year, int monthStart, int monthEnd);

//	     List<YearlyPatientCount> getYearlyPatientCount();
}
