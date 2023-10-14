package com.project.Icare.CollectionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class YearlyPatientCount {
    private int year;
    private long count;
}

