package com.project.webapp.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "admin")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Admin {

    private String id;
    private String uname;
    private String email;
    private String password;
    private String firstName;
    private  String lastName;
    private String role;
}
