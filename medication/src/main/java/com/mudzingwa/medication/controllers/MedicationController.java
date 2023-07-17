package com.mudzingwa.medication.controllers;

import com.mudzingwa.medication.dtos.Medicationdtos;
import com.mudzingwa.medication.entities.Medication;
import com.mudzingwa.medication.responses.MedicationResponse;
import com.mudzingwa.medication.services.MedicationServiceInterf;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableFeignClients
@RequestMapping("/medication")
@RequiredArgsConstructor
public class MedicationController {
    private final MedicationServiceInterf medicationServiceInterf;

    @PostMapping("/save")
    public ResponseEntity<MedicationResponse> createMedication(@RequestBody Medicationdtos medicationdtos){
        return new ResponseEntity<>(medicationServiceInterf.createMedications(medicationdtos), HttpStatus.CREATED);
    }
    @GetMapping("/find-medication/{id}")
    public ResponseEntity<Medication> findMedication(@PathVariable("id") Integer id){
        return  new ResponseEntity<>(medicationServiceInterf.findOne(id),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
   public ResponseEntity<MedicationResponse> updateMedication(@RequestBody Medicationdtos medicationdtos,@PathVariable("id") Integer id){
        return new ResponseEntity<>(medicationServiceInterf.UpdateMedication(medicationdtos,id),HttpStatus.CREATED);
   }
   @GetMapping("/find-all")
   public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(medicationServiceInterf.findAll(),HttpStatus.OK);
   }


}
