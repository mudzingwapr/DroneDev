package com.mudzingwa.medication.services;

import com.mudzingwa.medication.dtos.Medicationdtos;
import com.mudzingwa.medication.entities.Medication;
import com.mudzingwa.medication.responses.MedicationResponse;

import java.util.List;

public interface MedicationServiceInterf {
    public MedicationResponse createMedications(Medicationdtos medicationdtos);
    public MedicationResponse UpdateMedication(Medicationdtos medicationdtos,Integer id);
    public List<Medication> findAll();
    public Medication findOne(Integer id);
    public void deleteMedication(Integer id);
}
