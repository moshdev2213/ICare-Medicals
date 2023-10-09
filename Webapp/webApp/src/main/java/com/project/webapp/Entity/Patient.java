package com.project.webapp.Entity;
import java.util.Date;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "patient")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Patient {
    @Id
    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String uname;
    private String gender;
    private String bloodGroup;
    private int age;
    private Address address;
    private Date date;
    private String tel;
}
