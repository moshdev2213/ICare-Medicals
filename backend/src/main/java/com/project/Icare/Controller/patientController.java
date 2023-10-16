package com.project.Icare.Controller;

//import com.project.webapp.Entity.patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.Icare.Collection.Patient;
import com.project.Icare.CollectionDTO.RegistrationDataDto;
import com.project.Icare.Service.EmailSender;
import com.project.Icare.Service.patientService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patient")
@CrossOrigin("http://localhost:5173") // Removed trailing slash
public class patientController {

    @Autowired
    private patientService pService;
    private final EmailSender emailSender;

    public patientController(EmailSender emailSender) {
        this.emailSender = emailSender;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Patient insertPatient(@RequestBody Patient patient) {

        if(patient!=null){


            emailSender.sendEmail(patient.getEmail(),"Registration Notice","Dear "+patient.getFirstName()+", \n Your registration was successes");

        }
        return pService.addPatient(patient);
    }

    @GetMapping
    public List<Patient> fetchPatients() {
        return pService.getPatients();
    }
    @GetMapping("/{pid}")
    public Patient getPatient(@PathVariable String pid){
        return pService.getPatientById(pid);
    }
    @PutMapping
    public Patient modifypatient(@RequestBody Patient patientRequest){
        return pService.updatePatient(patientRequest);
    }

    @DeleteMapping("/{patientId}")
    public String removePatient(@PathVariable String patientId){
        return pService.deletePatient(patientId);
    }

    @GetMapping("/registration-data")
    public ResponseEntity<Map<String, RegistrationDataDto>> getRegistrationData( //parameters
            @RequestParam("year") int year,      //1
            @RequestParam("monthStart") int monthStart,  //2
            @RequestParam("monthEnd") int monthEnd) {   //3

        Map<String, RegistrationDataDto> registrationData = pService.getRegistrationData(year, monthStart, monthEnd);

        return ResponseEntity.ok(registrationData);
    }

//    @GetMapping("/yearly-patient-count")
//    public List<YearlyPatientCount> getYearlyPatientCount() {
//        return pService.getYearlyPatientCount();
//    }



}
