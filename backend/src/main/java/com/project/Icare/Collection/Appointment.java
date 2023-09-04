package com.project.Icare.Collection;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "appointment")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Appointment {
	@Id
	private String id;
	private String docEmail;
	private String venue;
	private String date;
	private String time;
	private String docName;
	private String patEmail;
	private String patName;
	private String patNumber;
	private int reference;
	private double amount;
	private String added;
	private Date edited;

}
