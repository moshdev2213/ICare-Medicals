package com.project.webapp.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "doctor")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Doctor {
    @Id
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String timeAvailabe;
    private String description;
    private String specializing;
    private int status;
    private double amount;
    private int cured;
    private String venue;
    private String added;
    private Date edited;
}
