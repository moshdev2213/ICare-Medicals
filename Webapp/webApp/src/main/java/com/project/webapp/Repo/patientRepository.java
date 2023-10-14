package com.project.webapp.Repo;

import com.project.webapp.DTO.YearlyPatientCount;
import com.project.webapp.Entity.Patient;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface patientRepository extends MongoRepository<Patient,String> {

    // Define a custom query method to find patients by month and year
//    @Query("{ 'date': { '$regex' : ?0, '$options' : 'i' } }")
//    List<Patient> findPatientsByMonthAndYear(String monthAndYear);


    @Query("{ 'gender': ?0, 'date': { '$gte' : ?1, '$lte' : ?2 } }")
    List<Patient> findPatientsByGenderAndDate(String gender, Date startDate, Date endDate);


    @Query("{'$group': {_id: { $year: '$date' }, count: { $sum: 1 }}}")
    List<YearlyPatientCount> getYearlyPatientCount();



}
