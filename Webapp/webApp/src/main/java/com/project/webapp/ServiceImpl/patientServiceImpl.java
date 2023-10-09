package com.project.webapp.ServiceImpl;

import com.project.webapp.DTO.RegistrationDataDto;
import com.project.webapp.DTO.YearlyPatientCount;
import com.project.webapp.Entity.Patient;

import com.project.webapp.Repo.patientRepository;
import com.project.webapp.Service.patientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class patientServiceImpl implements patientService {

    @Autowired
    private patientRepository repository;

    @Override
    public Patient addPatient(Patient patient) {
        // Generating a unique patient ID
        String patientId = UUID.randomUUID().toString().split("-")[0];
        patient.setId(patientId);
        return repository.save(patient);
    }

    @Override
    public List<Patient> getPatients() {
        return repository.findAll();
    }

    @Override
    public Patient getPatientById(String pid) {
        return  repository.findById(pid).orElse(null);
    }

    @Override
    public Patient updatePatient(Patient patientRequest) {
        Patient existingPatient = repository.findById(patientRequest.getId()).orElse(null);

        if (existingPatient!=null){
            existingPatient.setFirstName(patientRequest.getFirstName());
            existingPatient.setLastName(patientRequest.getLastName());
            existingPatient.setAge(patientRequest.getAge());
            existingPatient.setAddress(patientRequest.getAddress());
            existingPatient.setTel(patientRequest.getTel());
            existingPatient.setBloodGroup(patientRequest.getBloodGroup());
            existingPatient.setEmail(patientRequest.getEmail());
            existingPatient.setPassword(patientRequest.getPassword());
            existingPatient.setUname(patientRequest.getUname());
            existingPatient.setGender(patientRequest.getGender());
            existingPatient.setTel(patientRequest.getTel());


            return repository.save(existingPatient);
        }

        return null;
    }

    @Override
    public String deletePatient(String patientId) {
        repository.deleteById(patientId);
        return patientId+"patient deleted from the dashboard";
    }

    @Override
    public Map<String, RegistrationDataDto> getRegistrationData(int year, int monthStart, int monthEnd) {
        Map<String, RegistrationDataDto> registrationDataMap = new HashMap<>();

        for (int month = monthStart; month <= monthEnd; month++) {
            Date startDate = getStartDate(year, month);
            Date endDate = getEndDate(year, month);

            //put to a list
            List<Patient> malePatients = repository.findPatientsByGenderAndDate("male", startDate, endDate);
            List<Patient> femalePatients = repository.findPatientsByGenderAndDate("female", startDate, endDate);

            //count
            int maleCount = malePatients.size();
            int femaleCount = femalePatients.size();

            //create new RegistrationDataDto and add counts to it
            RegistrationDataDto dataDto = new RegistrationDataDto(maleCount, femaleCount);
            //put that object to map
            registrationDataMap.put(getMonthYearLabel(year, month), dataDto);
        }

        return registrationDataMap;
    }

//    @Override
//    public List<YearlyPatientCount> getYearlyPatientCount() {
//        return repository.getYearlyPatientCount();
//    }

    // Helper methods to calculate start and end dates for a given month and year
    private Date getStartDate(int year, int month) {
        // Construct the start date for the given month and year
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1); // Month in Calendar is zero-based (January is 0)
        calendar.set(Calendar.DAY_OF_MONTH, 1); // First day of the month
        calendar.set(Calendar.HOUR_OF_DAY, 0); // Set the time to midnight (00:00:00)
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private Date getEndDate(int year, int month) {
        // Construct the end date for the given month and year
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1); // Month in Calendar is zero-based (January is 0)
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH)); // Last day of the month
        calendar.set(Calendar.HOUR_OF_DAY, 23); // Set the time to the end of the day (23:59:59)
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    private String getMonthYearLabel(int year, int month) {
        // Format the month and year as a label (e.g., "08/2023")
        String monthStr = String.format("%02d", month); // Zero-padding for single-digit months
        return monthStr + "/" + year;
    }




}
