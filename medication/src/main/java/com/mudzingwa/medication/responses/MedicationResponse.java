package com.mudzingwa.medication.responses;

import com.mudzingwa.medication.entities.Medication;
import lombok.Data;

@Data
public class MedicationResponse {
    private Medication medication;
    private String message;

}
