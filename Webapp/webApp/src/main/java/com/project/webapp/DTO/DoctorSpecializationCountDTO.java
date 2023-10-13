package com.project.webapp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSpecializationCountDTO {
    private String specialization;
    private long count;

    // Constructors, getters, and setters
}
