package com.project.webapp.Service;

import com.project.webapp.DTO.RegistrationDataDto;
import com.project.webapp.DTO.YearlyPatientCount;
import com.project.webapp.Entity.Patient;

import java.util.List;
import java.util.Map;

public interface patientService {
    Patient addPatient(Patient patient);

    List<Patient> getPatients();

    Patient getPatientById(String pid);

    Patient updatePatient(Patient patientRequest);

    String deletePatient(String patientId);


     Map<String, RegistrationDataDto> getRegistrationData(int year, int monthStart, int monthEnd);

//     List<YearlyPatientCount> getYearlyPatientCount();









}
