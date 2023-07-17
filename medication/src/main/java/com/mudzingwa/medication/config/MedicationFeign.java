package com.mudzingwa.medication.config;

import com.mudzingwa.medication.entities.Medication;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:3306",name="medication")
public interface MedicationFeign {
    @GetMapping("/{id}")
    public Medication getMedication(@PathVariable("id") Integer id);
}
