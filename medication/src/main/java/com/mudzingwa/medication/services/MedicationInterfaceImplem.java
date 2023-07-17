package com.mudzingwa.medication.services;

import com.mudzingwa.medication.config.MedicationFeign;
import com.mudzingwa.medication.dtos.Medicationdtos;
import com.mudzingwa.medication.entities.Medication;
import com.mudzingwa.medication.exception.ResourceNotFoundException;
import com.mudzingwa.medication.repositories.Medicationrepository;
import com.mudzingwa.medication.responses.MedicationResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MedicationInterfaceImplem implements MedicationServiceInterf{
    private final Medicationrepository medicationrepository;
    private final ModelMapper modelMapper;
    //private final MedicationFeign medicationFeign;

    @Override
    public MedicationResponse createMedications(Medicationdtos medicationdtos) {
        Medication medication= modelMapper.map(medicationdtos,Medication.class);
        Medication medication1= medicationrepository.save(medication);
        MedicationResponse medicationResponse= new MedicationResponse();
        medicationResponse.setMedication(medication1);
        medicationResponse.setMessage("Medication stored successfully");
        return medicationResponse;
    }

    @Override
    public MedicationResponse UpdateMedication(Medicationdtos medicationdtos, Integer id) {
        Medication medication =  medicationrepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Medication","Serial",id));
        Medication medication1 = modelMapper.map(medicationdtos, Medication.class);

        return null;
    }

    @Override
    public List<Medication> findAll() {
        List<Medication> medicationList = medicationrepository.findAll();
        return medicationList;
    }

    @Override
    public Medication findOne(Integer id) {
        Medication medication =  medicationrepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Medication","Serial",id));
        return medication;
    }

    @Override
    public void deleteMedication(Integer id) {
        Medication medication =  medicationrepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Medication","Serial",id));
        medicationrepository.delete(medication);
    }
}
